<div id="top"></div>

<!-- PROJECT SHIELDS -->
[![selenium.dev](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=Selenium&logoColor=white)](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
[![java.jdk](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/downloads/#jdk17-mac)

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <p align="center">
  <a href="https://www.selenium.dev/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Selenium_logo.svg/1280px-Selenium_logo.svg.png"/></a>
</p>

<h3 align="center">Selenium Java Experiment</h3>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

The main goal of this experiment is to share with the community how `Selenium Webdriver` works along with Java as a testing framework and to learn how nowadays test automation projects are set up and worked utilizing the latest design patterns and frameworks, e.g. TestNG. This project has been built using POM / Page Factory, read [this article](https://www.browserstack.com/guide/page-object-model-in-selenium) to learn more.  The testing subject for this experiment is this website — [http://the-internet.herokuapp.com/](http://the-internet.herokuapp.com/).

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites
This is a Maven project, create the following under `<dependencies>` in your `pom.xml` file if they are not there already.

* Selenium Webdriver
  ```xml
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.1.1</version>
    </dependency>
  ```
* TestNG Framework
  ```xml
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.8</version>
      <scope>test</scope>
    </dependency>
  ```
  
* Selenium Webdriver for Google Chrome v 97.0.4692.99. Download from [here](https://chromedriver.storage.googleapis.com/index.html?path=97.0.4692.71/) if needed.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact
Asim Khan - [@asimkhan](mailto:"asim.khan@moduscreate.com")

Israel Alfaro - [@israelalfaro](mailto:"israel.alfaro@moduscreate.com")

Pedro Hyvo - [@pedrohyvo](https://www.linkedin.com/in/pedrohyvo/)

<p align="right">(<a href="#top">back to top</a>)</p>
