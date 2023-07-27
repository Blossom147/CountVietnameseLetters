import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountVietnameseLetters {

    public static ArrayList<String> findVietnameseLetters(String inputStr) {
        // Tạo một HashMap để ánh xạ các chữ cái Tiếng Việt sang chữ cái Latin
        HashMap<String, String> vietnameseLetters = new HashMap<>();
        vietnameseLetters.put("ă", "aw");
        vietnameseLetters.put("â", "aa");
        vietnameseLetters.put("đ", "dd");
        vietnameseLetters.put("ê", "ee");
        vietnameseLetters.put("ô", "oo");
        vietnameseLetters.put("ơ", "ow");
        vietnameseLetters.put("ư", "w");

        ArrayList<String> result = new ArrayList<>();  // Danh sách lưu các chữ cái Tiếng Việt tìm thấy trong chuỗi nhập vào

        int i = 0;
        while (i < inputStr.length()) {
            String currentChar = inputStr.substring(i, i + 1);

            // Nếu ký tự tại vị trí hiện tại và ký tự tiếp theo có thể tạo thành một chữ cái Tiếng Việt
            if (i < inputStr.length() - 1) {
                String nextChar = inputStr.substring(i + 1, i + 2);
                String potentialVietnameseLetter = currentChar + nextChar;
                if (vietnameseLetters.containsValue(potentialVietnameseLetter)) {
                    // Lấy chữ cái Tiếng Việt và thêm vào danh sách kết quả
                    result.add(potentialVietnameseLetter);
                    i += 2;  // Tăng chỉ số lên 2 vì đã xét 2 ký tự liên tiếp
                    continue;
                }
            }
            // Xử lý riêng cho chữ cái "w"
            if (currentChar.equals("w")) {
                result.add(currentChar);
                i += 1; // Tăng chỉ số lên 1 vì đã xét 1 ký tự
                continue;
            }
            // Nếu ký tự tại vị trí hiện tại là một chữ cái Tiếng Việt
            if (vietnameseLetters.containsKey(currentChar)) {
                // Thêm chữ cái Tiếng Việt vào danh sách kết quả
                result.add(currentChar);
                i += 1;  // Tăng chỉ số lên 1 vì đã xét 1 ký tự
            }

            i++;  // Tiếp tục kiểm tra các ký tự tiếp theo
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String inputStr = scanner.nextLine();
        scanner.close();
        // hwfdawhwhcoomddfgwdc
        ArrayList<String> result = findVietnameseLetters(inputStr);
        System.out.println("Kết quả: " + String.join(", ", result));
        System.out.println("Số lượng phần tử: " + result.size());
    }
}
