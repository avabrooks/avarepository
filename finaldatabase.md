[Home](https://avabrooks.github.io/avarepository/) | [Blog](https://avabrooks.github.io/avarepository/blog) | [Tech Talk Repl](https://replit.com/@avabrooks/Tri-3-TT#README.md)

<h2> Documentation of Work: </h2>

* Posts database setup
  * Posts [Database](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/Posts.java#L19-L39)
    * [SQL Repository](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsSqlRepository.java)
    * [JPA Repository](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsJpaRepository.java#L16-L19) w/ query implementation 
    * [ModelRepository](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/ModelRepository.java#L210-L228) use with Posts database
 * [**Create post:**](http://swagketo.tk/createpost)
    * Front end with [form](https://github.com/avabrooks/swagketo/blob/master/src/main/resources/templates/userpages/createpost.html#L22-L38) and thyme leaf use
    * [Back end](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsSqlMvcController.java#L26-L38) with post and get mapping to save to database
<img src="src/main/resources/static/images/Screenshot (178).png"
    alt="Markdown Monster icon"
    style="float: left; margin-right: 10px;" />
  * [**Displaying all posts and search:**](http://swagketo.tk/allposts)
    * Front End:
      * Displaying [all posts](https://github.com/avabrooks/swagketo/blob/master/src/main/resources/templates/userpages/posts.html#L43-L49) w/ thyme leaf
      * Search [input box](https://github.com/avabrooks/swagketo/blob/master/src/main/resources/templates/userpages/posts.html#L27-L31)
      * [Javascript](https://github.com/avabrooks/swagketo/blob/master/src/main/resources/templates/userpages/posts.html#L58-L105) to fetch name and message
      * [Result](https://github.com/avabrooks/swagketo/blob/master/src/main/resources/templates/userpages/posts.html#L37-L39) display of search
    * Back End:
      * [Get Mapping](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsSqlMvcController.java#L19-L24) for page
      * [API Controller](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsApiController.java) for Posts 
      * [Query](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/posts/PostsJpaRepository.java#L16-L19) to search from db from name and message
      * Model Repository [posts section](https://github.com/avabrooks/swagketo/blob/master/src/main/java/com/nighthawk/csa/database/ModelRepository.java#L210-L228)

<img src="src/main/resources/static/images/Screenshot (177).png"
     alt="Markdown Monster icon"
     style="float: left; margin-right: 10px;" />
 <img src="src/main/resources/static/images/Screenshot (179).png"
 alt="Markdown Monster icon"
 style="float: left; margin-right: 10px;" />

