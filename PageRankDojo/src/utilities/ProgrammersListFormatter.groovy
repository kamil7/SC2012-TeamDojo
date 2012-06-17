package utilities

import domain.Programmer;

class ProgrammersListFormatter {
	
	def private static SEPARATOR = "\t\t"
	
	def static formatHeader() {
		return "Name"+SEPARATOR+"Skills"+SEPARATOR+"Recommendations"
	}
	
	def static format(Programmer p) {
		def programmerDetails = p.name +SEPARATOR+p.skills+SEPARATOR+p.recommendations
		
		return programmerDetails.replace('[', '').replace(']', '') 
	}
	
	def static format(List<Programmer> programmers) {	
		def programmersList = formatHeader() + "\n"
		
		def c= [ compare:
			{a,b-> a.equals(b)? 0: a.name<b.name? -1: 1 }
		  ] as Comparator
	  	programmers.sort(c)
		  
		for (programmer in programmers) {
			programmersList += format(programmer) + "\n"
		}
		
		return programmersList
	}
	
	def static print(List<Programmer> programmers) {
		print format(programmers)
	}
	
}
