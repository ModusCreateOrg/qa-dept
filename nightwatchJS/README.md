
<br />

# NightwatchJS
<!-- CONTENTS -->
## Contents

- [Intro](/nightwatchJS/Intro)
- [Installation](/nightwatchJS/Installation)
- [Write Tests](/nightwatchJS/WriteTest)
- [How to Run](/nightwatchJS/HowtoRun)
- [Reporting](/nightwatchJS/Reporting)

<br/>

<!-- Intro -->
## Intro
This project is to automate Ecosia web application using NightwatchJS framework.

NightwatchJS is E2E testing solution for web applications

<!-- Installation -->
## Installation

1. Install NodeJS on your machine, go to [NodeJS](https://nodejs.org/en/) for respective platform downloads
2. Install npm , (Node Package Manager) from [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) this is a package manager helps in installing required dependencies with apt versions. For beginners this is just like Maven in Java projects.
3. `npm init --y`  
 this command will create `package.json` file with default values. You can update project name, version, scripts, licenses.
4. ` npm install nightwatch`  
 this command will install nightwatch dependency with latest stable version available.
5. `npm install chromedriver`    
this command will install chromedriver dependency and no more configuration needed unlike old way of setting browser path & references.    
6. Current test automation frameworks run based on configuration starting from test runner, browser capabilities, environments, features/specs/steps/pages references, reporting etc. Similarly Nightwatch also used `nightwatch.conf.js` configuration file. Add a file with same name and copy paste below code.
```
module.exports = {
  "src_folders" : ["tests"],

  "webdriver" : {
    "start_process": true,
    "server_path": "node_modules/.bin/chromedriver",
    "port": 9515
  },

  "test_settings" : {
    "default" : {
      "desiredCapabilities": {
        "browserName": "chrome"
      }
    }
  }
}
```
7. Refer to docs (https://nightwatchjs.org/guide/configuration/settings.html) for complete settings default values.
8. Global file usage, you can define `globals.js` an external file instead of having them in nightwatch config file.
you can setup hooks like before, after, beforeEach, afterEach which are mostly re-usable for multiple specs
copy the below code as its defaults
```
module.exports = {
  'default' : {
    isLocal : true,
  },

  'integration' : {
    isLocal : false
  },

  // External before hook is ran at the beginning of the tests run, before creating the Selenium session
  before: function(done) {
    // run this only for the local-env
    if (this.isLocal) {
      // start the local server
      App.startServer(function() {
        // server listening
        done();
      });
    } else {
      done();
    }
  },

  // External after hook is ran at the very end of the tests run, after closing the Selenium session
  after: function(done) {
    // run this only for the local-env
    if (this.isLocal) {
      // start the local server
      App.stopServer(function() {
        // shutting down
        done();
      });
    } else {
      done();
    }
  },

  // This will be run before each test suite is started
  beforeEach: function(browser, done) {
    // getting the session info
    browser.status(function(result) {
      console.log(result.value);
      done();
    });
  },

  // This will be run after each test suite is finished
  afterEach: function(browser, done) {
    console.log(browser.currentTest);
    done();
  }
};
```
9. Reporting

<!-- Write Tests -->
## Write Tests

1. Create a separate folder for tests in your project, e.g.: tests. Each file inside it will be loaded as a test suite by the Nightwatch test runner.
2. Here's a basic test suite example which opens the search engine Ecosia.org, searches for the term "nightwatch", then verifies if the term first result is the Nightwatch.js website.
```
module.exports = {
  'Demo test ecosia.org' : function(browser) {
    browser
      .url('https://www.ecosia.org/')
      .waitForElementVisible('body')
      .assert.titleContains('Ecosia')
      .assert.visible('input[type=search]')
      .setValue('input[type=search]', 'nightwatch')
      .assert.visible('button[type=submit]')
      .click('button[type=submit]')
      .assert.containsText('.mainline-results', 'Nightwatch.js')
      .end();
  }
};
```
3. BDD example
...


<!-- How to Run -->
## How to Run
1. npx nightwatch [source] [options]  - in this source is the test file location and options are different capabilities to run
for our tests run the following command  
`npx nightwatch tests/Demo.js`  
It invokes chrome browser with single test

OR

2. Add "tests/" to the source folder in config file in this way ` "src_folders" : ["tests/"],`
3. Add nightwatch to the test script in package.json in this way 
```
"scripts": {
    "test": "nightwatch"
  },
```
4. Now run `npm test`  
this command will trigger all tests and its subfolder tests via Chrome browser



    
