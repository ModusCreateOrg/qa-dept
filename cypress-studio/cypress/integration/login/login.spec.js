describe('Cypress Studio code example', () => {
  
  it('can login successfully', () => {
    /* ==== Generated with Cypress Studio ==== */
    cy.visit('https://www.saucedemo.com/');
    cy.get('[data-test="username"]').clear();
    cy.get('[data-test="username"]').type('standard_user');
    cy.get('[data-test="password"]').clear();
    cy.get('[data-test="password"]').type('secret_sauce');
    cy.get('[data-test="login-button"]').click();
    cy.get('.title').should('be.visible');
    cy.get('.title').should('have.text', 'Products');
    /* ==== End Cypress Studio ==== */
  });

})