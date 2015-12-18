package test.java.base;

public interface Config {

	final String url = System.getProperty("url",
			"http://172.18.84.196:9090/app/app/index.html");
	// final String username="psingh";
	// final String password="P@ssw0rd";
}
