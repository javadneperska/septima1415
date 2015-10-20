package pitko.erik.cv21;

public class Language {
	public String language;
	public UrovenCJ level;
	
	public Language(String language, UrovenCJ level) {
		super();
		this.language = language;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Language [language=" + language + ", level=" + level + "]";
	}
	

}
