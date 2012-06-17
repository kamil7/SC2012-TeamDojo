package utilities;

import domain.Programmer;
import utilities.ProgrammersListFormatter;
import groovy.util.GroovyTestCase;

class ProgrammersListFormatterTest extends GroovyTestCase {

	def testSkills = ['Java', 'groovy', 'c']
	def testRecommendations = ['Ed', 'Ben', 'Jon']
	
	void test_ShouldFormatHeader() {
		assert ProgrammersListFormatter.formatHeader() == 'Name		Skills		Recommendations'
	}
	
	void test_ShouldFormatProgrammerDetails() {
		def testSkills = ['Java', 'groovy', 'c']
		def testRecommendations = ['Ed', 'Ben', 'Jon']
		def p = new Programmer(	name:'Tom', 
								skills:testSkills,
								recommendations:testRecommendations)

		assert ProgrammersListFormatter.format(p) == 'Tom		Java, groovy, c		Ed, Ben, Jon'
	}
	
	void test_ShouldFormatProgrammersListAndOrderByName() {
		
		def programmers = new ArrayList<Programmer>()
		
		def p1 = new Programmer(name:'Tom',
								skills:testSkills,
								recommendations:testRecommendations)
		programmers.add(p1)
		
		def p2 = new Programmer(name:'Ben',
								skills:testSkills,
								recommendations:testRecommendations)		
		programmers.add(p2)
		
		def expectedOutput 	= 	'Name		Skills		Recommendations\n'
		expectedOutput 		+= 	'Ben		Java, groovy, c		Ed, Ben, Jon\n'
		expectedOutput 		+=  'Tom		Java, groovy, c		Ed, Ben, Jon\n'
		
		assert ProgrammersListFormatter.format(programmers) == expectedOutput
			
	}
}
