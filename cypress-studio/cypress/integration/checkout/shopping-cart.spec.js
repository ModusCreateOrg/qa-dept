// shopping-cart.spec.js created with Cypress
//
// Start writing your Cypress tests below!
// If you're unfamiliar with how Cypress works,
// check out the link below and learn how to write your first test:
// https://on.cypress.io/writing-first-test
/* ==== Test Created with Cypress Studio ==== */
it('can add a product into cart', function() {
  /* ==== Generated with Cypress Studio ==== */
  cy.visit('https://www.saucedemo.com/');
  cy.get('[data-test="username"]').clear();
  cy.get('[data-test="username"]').type('standard_user');
  cy.get('[data-test="password"]').clear();
  cy.get('[data-test="password"]').type('secret_sauce');
  cy.get('[data-test="login-button"]').click();
  cy.get('.title').should('be.visible');
  cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click();
  cy.get('.shopping_cart_link').click();
  cy.get('.inventory_item_name').should('have.text', 'Sauce Labs Backpack');
  cy.get('.cart_quantity').should('have.text', '1');
  cy.get('.inventory_item_price').should('have.text', '$29.99');
  cy.get('[data-test="checkout"]').click();
  cy.get('[data-test="firstName"]').clear();
  cy.get('[data-test="firstName"]').type('John');
  cy.get('[data-test="lastName"]').clear();
  cy.get('[data-test="lastName"]').type('Smith');
  cy.get('[data-test="postalCode"]').clear();
  cy.get('[data-test="postalCode"]').type('90001');
  cy.get('[data-test="continue"]').click();
  cy.get('[data-test="finish"]').click();
  cy.get('.complete-header').should('be.visible');
  cy.get('.complete-header').should('have.text', 'THANK YOU FOR YOUR ORDER');
  cy.get('.complete-text').should('have.text', 'Your order has been dispatched, and will arrive just as fast as the pony can get there!');
  cy.get('.pony_express').should('be.visible');
  /* ==== End Cypress Studio ==== */
});
