package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodingTest {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("123"));
//		$2a$10$/Xipf1l7XlmodEcQBif0J.MhA50nTX4f66Ip.9ksQ8R2QzKqJJvEK
//	    $2a$10$enWuOlU8YWUlV1KVfnSmFOF7SbEus9mGxjAsbWhTGxb4Co0Y.ksAi
		boolean result = encoder.matches("123","$2a$10$lrQz6ulnQMelF0r2PxFe9OuhPfcj4uvef/I97FFLRWjpCAJOMmZ8G");
		
		System.out.println("result : " + result);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
