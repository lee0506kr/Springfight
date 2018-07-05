package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import model.Book;

@Service
public class NaverBookService {

	/*
	 * Client ID : mw70x1ElhTxkrQGv1i4B Client Secret : ebOXL2uLOq 네이버에 검색어 전달해서 결과
	 * 받아옴 결과(json)를 파싱해서 내가 원하는 모양으로 바꿈... 내가 원하는 모양은 책정보기 여러개 들어있는 모양 List<Book>
	 */
	private static final String CLIENT_ID = "mw70x1ElhTxkrQGv1i4B";
	private static final String CLIENT_Secret = "ebOXL2uLOq";

	public List<Book> SearchBooks(String keyword) throws Exception {

		List<Book> bookList = new ArrayList<Book>();

		String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");

		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + encodedKeyword;

		// 요청시에,client id와 secret을 같이 넘겨주어야 한다.

		URL url = new URL(apiURL);

		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
		connection.setRequestProperty("X-Naver-Client-Secret", CLIENT_Secret);

		int responseCode = connection.getResponseCode();

		BufferedReader br = null;
		if (responseCode == 200) {
			// 정상 호출
			// 정상적으로 호출되었으면 데이터가 있다. >>> 데이터를 받아와서 가공
			// 데이터의 형태는 json형태의 문자열

			// 문자열 읽어오기
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		} else {
			// 예외 발생
			br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

		}

		String inputLine = null;

		StringBuilder sb = new StringBuilder();

		while ((inputLine = br.readLine()) != null) {
			// 버퍼에서 읽어온 문자열을 계속 연결
			sb.append(inputLine);
		}
		br.close();

		//System.out.println("네이버가 응답한 데이터 : " + sb.toString());

		// json형태의 문자열 받아왔으니깐
		// json 파싱(구문분석)해서 원하는 데이터 뽑아내기
		// 문자열을 json객체로 만들어서 객체형태로 접근하면 데이터를 얻어오기 쉬움
		JSONObject jsonObject = new JSONObject(sb.toString());
		// 응답받은 json 객체에서 실제 책 정보를 포함하고 있는 jsonarray 가져오기
		JSONArray items = jsonObject.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			// json array(책 여러권 정보) 반복하면서 한권의 데이터 꺼내오기
			JSONObject item = items.getJSONObject(i);
			Book book = new Book();
			book.setTitle(item.getString("title"));
			book.setAuthor(item.getString("author"));
			book.setDescription(item.getString("description"));
			book.setDiscount(item.getString("discount"));
			book.setImage(item.getString("image"));
			book.setIsbn(item.getString("isbn"));
			book.setLink(item.getString("link"));
			book.setPrice(item.getInt("price"));
			book.setPubdate(item.getString("pubdate"));
			book.setPublisher(item.getString("publisher"));
			
			bookList.add(book);
			
		}
		
		System.out.println("검색 도서 목록 : " + bookList);

		return bookList;
	}

}
