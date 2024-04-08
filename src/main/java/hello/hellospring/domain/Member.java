package hello.hellospring.domain;

public class Member {

    private Long id; //구분하기 위해서 저장할 때 시스템이 정해주는 데이터 아이디 (사용자가 설정x)
    private String name; //고객이 회원가입 할 때 적는 이름.
    // 정의했던 요구사항

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
