
describe('My Test Suite', () => {
    let testData; //variabename

  
   
    before(() => {
      cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
       cy.fixture('testdata.json').then((data) => {
         testData = data;
       })
    })
   
    it('should verify the page title', () => {
       cy.title().should('include', testData.expectedTitle)
       cy.get('[id="navbar"]').contains('a', 'Speaking').should('be.visible').click()
       cy.title().should('include', testData.expectedPageTitle)
       cy.get('h2[class="wp-block-heading"]').contains(testData.expectedText).should('be.exist')
    })

  })

  // To open the cypress browser give the command in VS code Terminal
  //npx  cypress open - used to open the Cypress Test Runner.

  
  
  
   
  