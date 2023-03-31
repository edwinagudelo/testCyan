package com.sbi.TestJPA.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbi.TestJPA.model.Peticion;
import com.sbi.TestJPA.model.Noticia;
import com.sbi.TestJPA.model.Analisis;
import com.sbi.TestJPA.repository.PeticionRepo;
import com.sbi.TestJPA.repository.NoticiaRepo;
import com.sbi.TestJPA.repository.AnalisisRepo;
import com.sbi.TestJPA.util.Constantes;

@Service
public class ServicioNoticias {
	
	@Autowired
    private PeticionRepo petiRepo;
	@Autowired
	private NoticiaRepo notiRepo;
	@Autowired
	private AnalisisRepo analiRepo;
	
	public List<Integer> procesarURL(List<String> lUrl) {
		List<Integer> retorno = new ArrayList<Integer>();
		HashSet<String> hexc = new HashSet<String>( Arrays.asList(Constantes.StrExclusiones.split(",") ) );
		
		for(String strUrl : lUrl) {
			Peticion tpet = new Peticion(strUrl);
			Set<Noticia> tsnoti = new HashSet<Noticia>();
			Set<Analisis> tsanali = new HashSet<Analisis>();
			HashMap<String, Analisis> totalanalisis = new HashMap<String, Analisis>(); 
			
			try {
				XmlReader reader = new XmlReader(new URL(strUrl));
				SyndFeed feed = new SyndFeedInput().build(reader);
                for (SyndEntry entry : feed.getEntries()) {
                	Noticia tnoti = new Noticia(tpet, entry.getTitle().toString());
                	tsnoti.add(tnoti);
                }
                
                // Ahora analizo las noticias
                for (Noticia tnoti : tsnoti) {
                	String[] arrStr = tnoti.getNoticia().split(" ");
            		
            		for(String strtmp : arrStr) {
            			Analisis tanali = null;
            			if(hexc.contains(strtmp.toLowerCase()))
            				continue;
            			if(totalanalisis.containsKey(strtmp)) {
            				tanali = totalanalisis.get(strtmp);
            			}
            			else {
            				tanali = new Analisis(tpet,strtmp);
            			}
            			tanali.incrementar();
            			totalanalisis.put(strtmp, tanali);
            		}
                }
                
                // Lo paso al set
                for(Map.Entry<String,Analisis> m: totalanalisis.entrySet()) {
                	tsanali.add((Analisis)m.getValue());
        		}
                
                // Para cada url grabo
                petiRepo.save(tpet);
                for(Noticia tnoti : tsnoti) {
                	notiRepo.save(tnoti);
                }
                for(Analisis tanali : tsanali) {
                	analiRepo.save(tanali);
                }
                retorno.add(tpet.getId());
                
			}catch(Exception ex) {
				tpet.setResult(ex.getLocalizedMessage());
			}
		}
		return retorno;
	}
	
	public HashMap<String, Integer> frecuencia(Integer petid){
		HashMap<String, Integer> retorno = new HashMap<String, Integer>();
		int i = 0;
		List<Analisis> tanalisis = analiRepo.traerFrecuencia(petid);
		for(Analisis tanali : tanalisis) {
			if(i == Constantes.limite)
				break;
			i++;
			retorno.put(tanali.getPalabra(), tanali.getContador());
		}
		return retorno;
	}
	
}

