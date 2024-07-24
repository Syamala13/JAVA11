package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/java11")
public class DemoController {

	// demonstration of JAVA11 String methods

	@RequestMapping(path = "/repeatMethod/{userName}/{count}", method = { RequestMethod.GET, RequestMethod.POST })
	public String repeatMethod(@PathVariable String userName, @PathVariable int count) {
		return userName.repeat(count);
	}

	@RequestMapping(path = "/stripMethod/{userName}")
	public String stripMethod(@PathVariable String userName) {
		return userName.strip();
		// return userName.stripLeading();
		// return userName.stripTrailing();
	}

	@RequestMapping(path = "/isBlankMethod/{userName}", method = { RequestMethod.GET, RequestMethod.POST })
	public String isBlankMethod(@PathVariable String userName) {
		String uname = "   ";
		System.out.println(uname.isEmpty()); // false
		System.out.println(uname.isBlank()); // true
		if (userName.isBlank()) {
			return "Username was blank";
		} else {
			return "Username was not blank";
		}

	}

	@RequestMapping(path = "/linesMethod", method = { RequestMethod.GET, RequestMethod.POST })
	public String linesMethod() {
		String multiLine = "OOP is a programming paradigm \n" + "that focuses on creating objects \n"
				+ " as the primary building blocks of software.";
		Stream<String> individualLines = multiLine.lines();
		individualLines.forEach(System.out::println);
		return "Lines extracted successfully";
	}

	// demonstration of JAVA11 var

	@RequestMapping(path = "varVariable", method = { RequestMethod.GET, RequestMethod.POST })
	public void varVariable() {

		String name1 = "Sooraj Kumar"; // 1.8
		var name2 = "Sooraj Kumar"; // 11

		int num1 = 10; // 1.8
		var num2 = 10; // 11

		List<String> list1 = new ArrayList<String>(); // 1.8
		var list2 = new ArrayList<String>(); // 11

		Map<Integer, String> map1 = new HashMap<Integer, String>(); // 1.8
		var map2 = new HashMap<Integer, String>(); // 11

		Map<String, List<String>> stringmap1 = new HashMap<>(); // 1.8
		var stringmap2 = new HashMap<String, List<Object>>(); // 11

	}

	// demonstration of JAVA11 HttpClient Library

	@RequestMapping(path = "/1.8httpClient", method = { RequestMethod.GET, RequestMethod.POST })
	public String httpclient() {
		// 1.8
		try {
			// URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

			URL url = new URL("https://www.javatpoint.com/dbms-normalization");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuffer response = new StringBuffer();

			String line;

			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			br.close();
			con.disconnect();
			return response.toString();
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(path = "/11httpClient", method = { RequestMethod.GET, RequestMethod.POST })
	public String advHttpclient() {

		// 11 Instead of HttpUrlConnection httpClient Library

		try {
			URI uri = new URI("https://www.javatpoint.com/dbms-normalization");

			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();

		} catch (Exception e) {
			return null;
		}

	}

	@RequestMapping(path = "/1.8readFile", method = { RequestMethod.GET, RequestMethod.POST })
	public String readFile() {

		// First Way with byte array

//		Path path=Paths.get("D:\\demo.txt");
//		try {
//			byte[] bytes=Files.readAllBytes(path);
//			
//			String content=new String(bytes,StandardCharsets.UTF_8);
//			
//			return content;
//			
//		}catch(Exception e) {
//			return null;
//		}

		// Second Way with buffer reader

		Path path = Paths.get("D:\\demo.txt");

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
			System.out.println("File content: " + content.toString());
			return content.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(path = "/11readFile", method = { RequestMethod.POST, RequestMethod.GET })
	public String readFile1() {
		try {
			Path path = Paths.get("D:\\demo.txt");
			String content = Files.readString(path);
			return content;
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(path = "/1.8writeFile", method = { RequestMethod.POST, RequestMethod.GET })
	public String writeFile() {
		// first Way with

//		Path path = Paths.get("D:\\demo.txt");
//		try {
//			String content = "This is the text message writting into file";
//			Files.write(path, content.getBytes(StandardCharsets.UTF_8));
//			return "success";
//		} catch (Exception e) {
//
//			return null;
//		}

		// Second Way with

		Path path = Paths.get("D:\\demo.txt");
		String content = "This is the text message writting into file";

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(content);
			return "File written successfully.";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(path = "/11writeFile", method = { RequestMethod.POST, RequestMethod.GET })
	public String writeFile1() {
		try {
			Path path = Paths.get("D:\\demo.txt");
			String content = "This is the text message writting into file";
			Files.writeString(path, content, StandardOpenOption.CREATE);
			return "success";
		} catch (Exception e) {
			return null;
		}

	}

	@RequestMapping(path = "/11copyOfMethod", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Integer> copyOfMethod() {

//		List<String> originalList = new ArrayList<>(Arrays.asList("java", "js", "html", "css"));
//		originalList.add("dot net");
//		List<String> immutableList = List.copyOf(originalList);
//		// immutableList.add("jquery"); //it will throw UnsupportedOperationException
//		originalList.add("react");
//		System.out.println("Original List: " + originalList);
//		System.out.println("Immutable List: " + immutableList);
//		return originalList;
		 System.out.println("Java version: " + System.getProperty("java.version"));		
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Map<String, Integer> map = new HashMap<>();
        // Example of teeing()
        Map<String, Integer> result = numbers.stream()
            .collect(Collectors.teeing(
                Collectors.summingInt(n -> n),  // First collector: summing integers
                Collectors.counting(),         // Second collector: counting elements
                (sum, count) -> {              // Combiner: creating a map from the results
                   
                    map.put("sum", sum);
                    map.put("count", Math.toIntExact(count));
                    return map;
                }
            ));
        System.out.println("Result: " + result);
        return new ArrayList<>();
        
      
	}
}
