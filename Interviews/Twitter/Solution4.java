package Twitter;

public class Solution4 {

	/*
	 * Complete the function below.
	 */
	// check if the given ip is IPv4
	static boolean checkIPv4(String ip) {
		String[] parts = ip.split("\\.");

		// IPv4 ip should have 4 parts
		if (parts.length != 4)
			return false;

		// check if each part of the ip is within [0, 255] range
		for (String part : parts) {
			// catch the possible exception
			try {
				int value = Integer.parseInt(part);
				if (value < 0 || value > 255)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;
	}

	// check if the given digit is hexa
	static boolean isHexa(char digit) {
		// if digit, then true
		if (Character.isDigit(digit) == true)
			return true;

		// transfortm to lowercase and check if the
		// digit is within [a, f] range
		digit = Character.toLowerCase(digit);
		if (digit >= 'a' && digit <= 'f')
			return true;

		return false;
	}

	// check if given ip is IPv6
	static boolean checkIPv6(String ip) {
		String[] parts = ip.split("\\:");

		// IPv6 ip should have 8 parts
		if (parts.length != 8)
			return false;

		// each part should consist of hexa digits
		for (String part : parts) {
			System.out.println(part);
			for (char digit : part.toCharArray())
				if (isHexa(digit) == false)
					return false;
		}

		return true;
	}

	static String[] checkIP(String[] ip) {
		String[] result = new String[ip.length];

		for (int i = 0; i < ip.length; i++) {
			if (checkIPv4(ip[i]) == true)
				result[i] = "IPv4";
			else if (checkIPv6(ip[i]) == true)
				result[i] = "IPv6";
			else
				result[i] = "Neither";
		}

		return result;
	}
}
