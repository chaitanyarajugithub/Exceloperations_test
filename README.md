# Exceloperations_test

This project is written in java and will serve an example of implementing a Selenium test project with Selenium3 and Maven.
Everything is set up and tests can be added straight away.
Used TestNG

## Implemented Browsers
Thanks to the awesome [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) it supports the following browsers and automatically downloads OS specific binaries for:
* Chrome
* Firefox
* PhantomJS
* Opera
* Internet Explorer
* Edge

#### The Webdriver Setup
The webdriver setup is based on the [WebDriverBuilder](https://github.com/christian-draeger/basic-selenium-project/blob/master/src/main/java/selenium/driver/WebDriverBuilder.java) and the [DesiredCapabilitiesFactory](https://github.com/christian-draeger/basic-selenium-project/blob/master/src/main/java/selenium/driver/DesiredCapabilitiesFactory.java)
to have a separation between driver instantiation and browser specific settings.

## Page Objects Pattern
page object pattern is used to have reusable WebElements/small helper methods seperated from actual test classes and give the opportunity to have nice structured and easily readable tests (without the overhead of BDD-Frameworks like Cucumber or JBehave).

## Annotations
Beside a bunch of [Convenient Methods] the basic-selenium-project provides some nice custom annotations to comfortably set some test conditions and/or assumptions
Example test that uses several annotations: [SearchIT.java](https://github.com/christian-draeger/basic-selenium-project/blob/master/src/test/java/selenium/testcases/SearchIT.java)

#### @Browser
The `@Browser` annotation includes or excludes certain browsers from the test execution

skip test if browser equals firefox:
```
@Browser(skip = FIREFOX)
```

it also supports list of browsers, e.g. skip test if browser equals firefox or phantomjs
```
@Browser(skip = { FIREFOX, PHANTOMJS })
```

it can be used the other way around as well e.g. if you want a certain test just to be executed with phantomjs you can do something like this:
```
@Browser(require = PHANTOMJS)
```
The browser require option is working equivalent to the skip option and also supports list of browsers

#### @BrowserDimension
If you want to test a responsive website it can be handy to set the browsers to some specific viewports.
To configure your breakpoints just edit them in the [test_data.properties](https://github.com/christian-draeger/basic-selenium-project/blob/master/src/test/resources/test_data.properties)

Resizing the browser window for specific tests can be done by e.g.:
``` 
@BrowserDimension(LARGE)
