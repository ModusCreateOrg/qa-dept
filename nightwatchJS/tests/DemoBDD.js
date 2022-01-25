describe('All features in  Ecosia website', function() {  
    this.tags = ['login', 'authentication'];

    test('search for a keyword', function(browser) {
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
    });


    test('search for a keyword using expect', function(browser) {
        browser.url('https://www.ecosia.org/');

    // expect element header to be present in 1000ms
    browser.expect.element('header').to.be.present.before(1000);

    // expect element header to have css property 'display'
    browser.expect.element('header').to.have.css('display');

    // expect element header to have attribute 'class' which contains text 'index-header'
    browser.expect.element('header').to.have.attribute('class').which.contains('main-header__content');

    // expect element .search-form to be an input tag
    browser.expect.element('.search-form').to.be.a('form');

    // expect element header to be visible
    browser.expect.element('header').to.be.visible;

    browser.end();
      });
  });
  