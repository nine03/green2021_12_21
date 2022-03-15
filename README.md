# green2021_12_21 
그린 컴퓨터 아카데미 수업 실습용 


### 깃 기본 명령어 정리 
- 환경설정<br>
git config --global user.name "nine03" <br>
git config --global user.email "youngjun_10@naver.com" <br>

git config --global --list <br>
git config user.name <br>
git config user.email <br>


- 초기화 <br>
git init <br>

- 리모트 저장소 등록 (깃허브에 있다) <br>
git remote add origin https://github.com/계정/레파지토리.git <br>

- 스테이지에 추가 및 commit(저장소에 등록) <br>
git add --all <br>
git commit -m "메세지" <br>

- 업로드 <br>
git push -u origin master <br>


- fetch(서버에가 임의 수정 되었을때) <br>
git fetch origin <br>
git checkout master <br>
git merge origin/master <br>
--- 수정내용 직접 확인 후 --- <br>
git add --all <br>
git commit -m "메세지" <br>
git push -u origin master <br>

- 수정된 리모트 레파지토리 가져오기 <br>
git pull origin <br>
