import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTML_Test {
    static String FILEPATH = "/Users/kimahyoung/Desktop";
    static String FILENAME = "property.html";
    public static void main(String[] args) {
        StringBuilder head = new StringBuilder();
        StringBuilder body = new StringBuilder();
        // HTML에서 head 태그 내에는 스타일 시트, 제목, 메타데이터 등 정보를 포함
        // 브라우저는 <head> 태그 내부 정보 해석해 페이지를 렌더링, <body> 태그 내 내용을 표시
        head.append("<html>")
                .append("<head>\n")
                // HTML 문제의 문자 인코딩을 설정하는 태그, UTF-8이 가장 대중적
                .append("<meta charset=\"UTF-8\"/>")
                // 문서의 제목 (브라우저 탭에 보이는 이름, 지정하지 않으면 파일명이 보임)
                .append("<title> 자바 환경정보 </title>")
                // <header> 문서 제목 스타일 지정 (폰트 굵기, 사이즈, 위 아래 여백)
                .append("<style>")
                .append("header {font-weight: bold; font-size: 30px; padding-top: 20px; padding-bottom: 20px; }")
                .append("</style>")
                // <table> 표 스타일 지정
                // border-collapse: collapse -> 두 셀의 경계 하나로 표시
                // width : 100 -> 표 너비 페이지 가득 채우기
                // th, td 요소 테두리 실선으로 표시, 테두리 두께 1px로 설정
                .append("<style>")
                .append("table { border-collapse: collapse; width: 100%; }")
                .append("th,td { border:solid 1px #000; }")
                .append("</style>")
                .append("</head>");

        // <body> 출력할 내용이 담김
        body.append("<body>")
                // <header> 문서에서 제목 부분
                .append("<header> 자바 환경정보 </header>")
                .append("<table>")
                // tr -> table row, 표에서 한 행을 의미, th나 td 요소를 포함함
                .append("<tr>")
                // th -> table header cell, 테이블의 첫번째 행이나 열에 위치, 요소 제목 내용
                .append("<th>키</th>")
                .append("<th> </th>")
                .append("</tr>");
                // td -> table data cell, 실제 데이터를 표시
        for(Object o1:System.getProperties().keySet()){
            String key = o1.toString();
            String value = System.getProperty(key);
            body.append("<tr>")
                    .append("<td>"+key+"</td>")
                    .append("<td>"+value+"</td>");
        }
        body.append("</table>")
                .append("</body>")
                .append("</html>");

        // file class
        // 파일 생성, 삭제, 수정, 파일의 정보를 얻어오는 목적으로 사용됨
        // file a = new file(String path); 로 file 객체를 생성하는 것은 파일/디렉토리 경로를 나타내는 객체를 생성하는 것
        // 파일을 자바 프로그램 객체로 변환시켜준다
        // a.createNewFile(); 메소드를 이용해 실제 파일을 생성해야 한다
        // createNewFile()은 동일 명의 파일이 존재하는 등 오류 발생 가능성이 있기 때문에 try catch(IO execption)으로 처리 필요

        // filewriter class
        // 파일에 어떤 내용을 쓰는데 사용
        // 생성자로 파일 경로, File 객체를 받을 수 있음
        // 생성자 뒷쪽에 append에 대한 값을 true, false로 받을 수 있다
        // true 일 경우, 파일을 계속 이어쓰는 방식으로 수정, false 일 경우 수정시 다시 생성됨 (기본 false)

        // BufferedWriter class
        // 임시 공간인 버퍼를 이용해서 많은 내용을 효율적으로 저장할 때 사용됨
        // 버퍼에 저장할 내용을 모아두었다가 한꺼번에 write 하는 방식
        // filewriter와 함께 사용할 수 있지만, file과는 함께 사용할 수 없다

        File html_test = new File(FILEPATH+"/"+FILENAME);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(html_test,false));
            writer.write(head.toString());
            writer.write(body.toString());
            writer.close();
        }
        catch (IOException error){
            error.printStackTrace();
        }

       // System.out.println(html_test.getAbsolutePath());
    }
}
