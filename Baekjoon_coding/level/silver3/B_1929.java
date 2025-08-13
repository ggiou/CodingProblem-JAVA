package Baekjoon_coding.level.silver3;
//M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
//첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
//한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
public class B_1929 {
    public static void main(String[] args) {
        String[] arrTmpImgFileNm = "8801114157510_2.png".split("\\.");
        String tmpImgFileNm = "";
        if (arrTmpImgFileNm.length > 1) {
            if (arrTmpImgFileNm[0].indexOf('_') > -1) {
                String[] arrTmpImgFileNm2 = arrTmpImgFileNm[0].split("_");
                if (arrTmpImgFileNm2.length > 1) {
                    tmpImgFileNm = arrTmpImgFileNm2[0] + "_2." + "jpg";
                }
            } else {
                tmpImgFileNm = arrTmpImgFileNm[0] + "_2." + "jpg";
            }
        }
        System.out.printf(tmpImgFileNm);
    }
}
