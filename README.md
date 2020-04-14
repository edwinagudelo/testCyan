# testCyan
Prueba Para Cyan

This is the solution for the test in: https://github.com/i-new/hiring_exercise-software_developer

## Notes:
1. For the first item: (http://localhost:8080/analyse/new)
Receives an array in JSON Format in the request body:

```
{
	"urls":[
		{"url":"https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss"}
		]
}
```
It generate an ID for each URL passed

2. For the second item: (http://localhost:8080/frequency/{id})
The response is limited to 5 first items or an empty JSON object.

3. Is Open de console for H2 query. There is 3 tables:
	a. Peticion: A register for each URL passed.
	b. Noticia: A register for each news in feed.
	c. Analisis: A word with counter.
The URL for the connection is http://localhost:8080/h2 , the parameter **JDBC URL** is  *jdbc:h2:mem:testdb* , user is *sa* and password is empty string.
