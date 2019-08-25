package design_pattern.structural;

/*
 * Adapter pattern lets you wrap an otherwise incompatible object in an adapter to make it compatible with another class.
 */

//Suppose there is an Analytics that works only with Json.
//And if there is a new type of document that is in xml
//we need to use adapter in between to convert xml to json to continue the analytic work with new document

abstract class DataFormat {
}

class Xml extends DataFormat {
}

class Json extends DataFormat {
}

class Analytic {
	public void analyze(JsonDocument jsonDocument) {
		
	}
}

interface JsonDocument {
	Json getData();
}

class AnalyticDocument implements JsonDocument {
	public Json getData() {
		return null;
	}
}

class NewXmlDocument {
	public Xml getAllData() {
		return null;
	}
}

class NewXmlDocumentAdapter implements JsonDocument {
	NewXmlDocument originalDocument;

	public NewXmlDocumentAdapter(NewXmlDocument doc) {
		originalDocument = doc;
	}

	public Json getData() {
		//convert xml data to json format here
		Xml data = originalDocument.getAllData();
		Json jsonData = convertXmlToJson(data);
		return jsonData;
	}

	private Json convertXmlToJson(Xml data) {
		return null;
	}

}

public class Adapter {

	public static void main(String[] args) {
		Analytic analytic = new Analytic();
		
		NewXmlDocument doc = new NewXmlDocument();
		NewXmlDocumentAdapter adapter = new NewXmlDocumentAdapter(doc);
		analytic.analyze(adapter);
	}

}
