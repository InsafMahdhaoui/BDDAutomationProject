import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/spec/features" }, plugin = { "pretty", "html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, // responsable au reporting,
																							// le rapport va etre placee
																							// dans le dossier target et
																							// du nom
																							// "cucumber-report.html"
		tags = ("@logout"), // contient l'annotation du scenario qu'on veut l'executer
		snippets = SnippetType.CAMELCASE, // forcer le generation des noms des methodes en stepDefinition en des noms
											// attachees et des 1 ere lettes majuscules
		monochrome = true // responsable a generer un console lisible
)

public class TestRunner {

}
