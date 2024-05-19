

describe('My Test Suite', () => {
    
    it('should verify the page title', () => {
        cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
      cy.title().should('include', 'Want to practice test automation? Try these demo sites! | Automation Panda')
    })
  
    it('should click on Speaking and verify the title of the page', () => {
        cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
        cy.get('[id="navbar"]').contains('a', 'Speaking').should('be.visible').click()
        cy.title().should('include', 'Speaking | Automation Panda')

  
    //should verify if "Keynote Addresses" is present and check the text
      
    cy.get('h2[class="wp-block-heading"]').contains('Keynote Addresses').should('be.exist')
      
        
      });
      
  })
  