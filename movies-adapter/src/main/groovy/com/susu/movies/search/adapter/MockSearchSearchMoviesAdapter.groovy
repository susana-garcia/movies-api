package com.susu.movies.search.adapter

import com.fasterxml.jackson.databind.ObjectMapper
import com.susu.movies.SearchMoviesResponse
import com.susu.movies.model.SearchMoviesRequest
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Created by Susana on 13/07/15.
 */

@Profile('mock')
@Component(value = 'moviesAdapter')
class MockSearchSearchMoviesAdapter implements SearchMoviesAdapter {

  @Override
  SearchMoviesResponse searchMovies(SearchMoviesRequest request) {
    if (request.query != 'error') {
      String response = '{"page":1,"results":[{"adult":false,"backdrop_path":"/3hGRV0xR11aUxCGAJ52F8MTxrno.jpg","genre_ids":[18,36],"id":152532,"original_language":"en","original_title":"Dallas Buyers Club","overview":"Basada en la vida real de Ron Woodroof, un cowboy de rodeo texano, drogadicto y mujeriego, al que en 1986 le diagnosticaron SIDA y le pronosticaron un mes de vida. Empez\\u00f3 entonces a tomar AZT, el \\u00fanico medicamento disponible en aquella \\u00e9poca para luchar contra tan terrible enfermedad","popularity":3.315893,"poster_path":"/9eheKEai9hb7oFDgKhIBJnHQfWv.jpg","release_date":"2013-11-22","title":"Dallas Buyers Club","video":false,"vote_average":7.8,"vote_count":813},{"adult":false,"backdrop_path":"/ywyDwqHwohgm62DyavOTpqJgFd2.jpg","genre_ids":[35,18,10749],"id":197033,"original_language":"en","original_title":"Geography Club","overview":null,"popularity":1.206364,"poster_path":"/DaGSmtXItpHG5GYouz3Q32AlRh.jpg","release_date":"2013-05-22","title":"Geography Club","video":false,"vote_average":6.9,"vote_count":17},{"adult":false,"backdrop_path":"/dm86y5UO6ti5y7cOGmlKXUOEib9.jpg","genre_ids":[35],"id":213983,"original_language":"en","original_title":"Club Sandwich","overview":null,"popularity":1.072229,"poster_path":"/69jTDK3HTnsNN759bM9qixLxbR3.jpg","release_date":"2013-09-05","title":"Club Sandwich","video":false,"vote_average":3,"vote_count":2},{"adult":false,"backdrop_path":null,"genre_ids":[18],"id":250731,"original_language":"en","original_title":"Club 60","overview":null,"popularity":0.005787,"poster_path":"/xQgbnbOjqoyFLgWMUh6j0I1nevw.jpg","release_date":"2013-12-06","title":"Club 60","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/hPaH0Pa9SBopovppsmHGjPRCpQY.jpg","genre_ids":[35,27],"id":139721,"original_language":"en","original_title":"Billy Club","overview":null,"popularity":1.00454,"poster_path":"/tAC6vnGSSl3zWh845VukAdEd0kC.jpg","release_date":"2013-10-01","title":"Billy Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/2KNGTv779ZaRnntbyJiVTiptc3F.jpg","genre_ids":[10749,18],"id":216780,"original_language":"en","original_title":"August Club","overview":null,"popularity":1.003535,"poster_path":"/8kuVM8bfjPJeB6hvfGSMg97VNQw.jpg","release_date":"2013-07-16","title":"August Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":null,"genre_ids":[],"id":169795,"original_language":"en","original_title":"Improvement Club","overview":null,"popularity":1.002957,"poster_path":"/mB27JqxnBw6LBGPo2cOm0UFPD8Y.jpg","release_date":"2013-03-15","title":"Improvement Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":null,"genre_ids":[18,10751],"id":268904,"original_language":"de","original_title":"Willkommen im Club","overview":null,"popularity":1.004952,"poster_path":"/c2PQFnmvS1BX3Kqw2fuhDyK1AUm.jpg","release_date":"2013-09-03","title":"Willkommen im Club","video":false,"vote_average":6,"vote_count":2},{"adult":false,"backdrop_path":null,"genre_ids":[],"id":339717,"original_language":"en","original_title":"The Turtleneck Club","overview":null,"popularity":1.002715,"poster_path":null,"release_date":"2013-04-16","title":"The Turtleneck Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":null,"genre_ids":[],"id":336102,"original_language":"en","original_title":"Howard Joins The Club","overview":null,"popularity":1.002461,"poster_path":null,"release_date":"2013-01-01","title":"Howard Joins The Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/rsv46SYFz7SxWVbC48uV26Xu1x9.jpg","genre_ids":[28,18,80],"id":219897,"original_language":"de","original_title":"Barrio Brawler","overview":null,"popularity":1.000117,"poster_path":"/8AyCFlw1d856UAAN21fnWOpQu4l.jpg","release_date":"2013-08-27","title":"Barrio Brawler","video":false,"vote_average":1.5,"vote_count":2},{"adult":false,"backdrop_path":null,"genre_ids":[],"id":333404,"original_language":"en","original_title":"The Wednesday Morning Breakfast Club","overview":null,"popularity":1.003143,"poster_path":null,"release_date":"2013-07-26","title":"The Wednesday Morning Breakfast Club","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/iDwiRzyJL4y6igo1FHiiA9FK07n.jpg","genre_ids":[14,27],"id":203039,"original_language":"en","original_title":"Snake Club: Revenge of the Snake Woman","overview":null,"popularity":0.145254,"poster_path":"/rWcJH5JRoJnK2J4ZmXdkC0Uh15y.jpg","release_date":"2013-02-28","title":"Snake Club: Revenge of the Snake Woman","video":false,"vote_average":2,"vote_count":2},{"adult":false,"backdrop_path":"/gpoye8qgyBZyQIMlhkDlDVWkrTp.jpg","genre_ids":[35],"id":86541,"original_language":"en","original_title":"Promoci\\u00f3n Fantasma","overview":"En \\u201cPromoci\\u00f3n fantasma\\u201d conoceremos a Modesto, un profesor que en ocasiones ve muertos. Esto no s\\u00f3lo le ha costado una fortuna en psiquiatras, sino que tambi\\u00e9n ha hecho que le despidan de todos los colegios donde ha trabajado. Su suerte cambia cuando consigue plaza en el Monforte y tiene que dar clase a cinco alumnos que han convertido un colegio de prestigio en la casa de los horrores. Modesto tiene que lograr que los cinco chicos aprueben el \\u00faltimo curso y se larguen de all\\u00ed de una vez por todas. Pero no lo va a tener f\\u00e1cil: los cinco llevan veinte a\\u00f1os muertos.","popularity":0.36572,"poster_path":"/aptm8RXm2Jg5QLBQl4Ew6y9NW55.jpg","release_date":"2012-02-03","title":"Promoci\\u00f3n fantasma","video":false,"vote_average":5.4,"vote_count":15},{"adult":false,"backdrop_path":"/mv91tU1OmRM6GlQMKkbKHFVzPKf.jpg","genre_ids":[],"id":262465,"original_language":"en","original_title":"Stone Sour: Live In Club Nokia","overview":null,"popularity":1.002433,"poster_path":"/11xtfN6NBPYMlaCiiDE0p6CMvcT.jpg","release_date":"2013-02-13","title":"Stone Sour: Live In Club Nokia","video":true,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/wREbjSW9tXQ6XxReh96BdwEpqBn.jpg","genre_ids":[10402],"id":291755,"original_language":"en","original_title":"Fish: Fishheads Club Live DVD 1","overview":null,"popularity":1.002429,"poster_path":"/8uGHkYUz0oZ3q1eho3fgdumuu9w.jpg","release_date":"2013-01-04","title":"Fish: Fishheads Club Live DVD 1","video":true,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/52ZK43TDilGIwBInhje9ciiAix1.jpg","genre_ids":[10402],"id":291761,"original_language":"en","original_title":"Fish: Fishheads Club Live DVD 2","overview":null,"popularity":1.002429,"poster_path":"/8uGHkYUz0oZ3q1eho3fgdumuu9w.jpg","release_date":"2013-01-04","title":"Fish: Fishheads Club Live DVD 2","video":true,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/mQL1tXBS48Y6swRZoUvRlhB1Z8S.jpg","genre_ids":[10751,10769],"id":223552,"original_language":"nl","original_title":"De Club van Sinterklaas & De Pietenschool","overview":null,"popularity":0.003442,"poster_path":"/jV0t1fZgfcMJ5M65wFYOptoeVKX.jpg","release_date":"2013-10-09","title":"De Club van Sinterklaas & De Pietenschool","video":false,"vote_average":0,"vote_count":0},{"adult":false,"backdrop_path":"/rv2j5bWJpDGkusTc1T7koxRJPq9.jpg","genre_ids":[12,35,10751],"id":159774,"original_language":"es","original_title":"Zipi y Zape y el club de la canica","overview":"Zipi y Zape, dos traviesos mellizos, son internados en el Esperanza, un colegio donde los juegos est\\u00e1n prohibidos. All\\u00ed fundar\\u00e1n el Club de la Canica, la resistencia infantil que desafiar\\u00e1 la autoridad de los adultos. Gracias a su inteligencia, su valent\\u00eda y su inquebrantable fe en la amistad, Zipi y Zape y el resto del club descubrir\\u00e1n un misterioso secreto que se oculta en el colegio y vivir\\u00e1n la aventura m\\u00e1s emocionante de sus vidas.","popularity":1.193802,"poster_path":"/AfONzb4VyoYjaip2UpyNBRqxr5r.jpg","release_date":"2013-10-04","title":"Zipi y Zape y el club de la canica","video":false,"vote_average":4.7,"vote_count":3},{"adult":false,"backdrop_path":"/JGssps6kvJ1QS173kje0PfIYom.jpg","genre_ids":[10402],"id":315995,"original_language":"en","original_title":"Two Door Cinema Club Live at Les Vieilles Charrues 2013","overview":null,"popularity":1.003013,"poster_path":"/kTQ0757SzHtzX2tlfCOxrExsMGY.jpg","release_date":"2013-07-18","title":"Two Door Cinema Club Live at Les Vieilles Charrues 2013","video":false,"vote_average":0,"vote_count":0}],"total_pages":2,"total_results":30}'
      new ObjectMapper().readValue(response, SearchMoviesResponse)
    } else {
      throw new SearchMoviesException("Error")
    }
  }
}