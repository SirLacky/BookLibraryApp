# BookLibraryApp
Application for libraries to share information about their book collections with customers. Application is deserializing json file and performing some basic methods like searching via ISBN, Category or calculating given author rating. 

## Used technologies:
  
 1. Maven + SpringBoot - for Dependencies, Spring Functionality, Jackson, Tomcat;
 1. Log4j - to use logger usability except System.out.println
 1. jUnit5 (jupiter: engine, api; surefire platform; launcher) - for full functionality 
 1. Apache TomCat - to develop environment for WebApp
 1. JSTL for jsp tags usage
 
## Basic functionalities:
 
 Searching book by ISBN:
 
 ![Screenshot](/images/isbn.gif)
 
 Searching books by Category:
 
 ![Screenshot](/images/cat.gif)
 
 Calculating author's average rating:
 
 ![Screenshot](/images/author.gif)
 
 ## How to start:
 
 Main file is located in BookLibrartApp Class with run method. After running whole web interface is available on address: http://localhost:8080/.
 
 ## Possible upgrades:
 
 Important:
 
 ---
  - Fix PreconditionViolationException which prevents from running all tests at the start of application.
  - Fix IllegalArgumentException which prevents .jar file from running as separate app from cmd prompt.
  - Use Design Pattern like Builder for better code quality.
 ---
 
 Less important:
 
  - Add more jUnit tests - validate included json file.
  - Add more methods - searching for books by page count, availability on given country, existing ebook etc.
  - Add more comments into code to allow Javadoc to automatically create documentation.
  - Allow to switch dataset from command line.
  - Improve FrontEnd ;)
  
  ## Authors note:
  
  This was my first ever project where I used JSON and tests. Learn a lot through this week. I hope my work will meet the requirements even in some part. Thank you for giving me opportunity to find out new stuff, and I hope see you soon :)