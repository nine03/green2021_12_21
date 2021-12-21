# green20211221
그린 컴퓨터 아카데미 수업 실습용

### 깃 기본 명령어 정리
- 환경설정
git config --global user.name "comstudynews"
git config --global user.email "comstudynews@gmail.com"

git config --global --list
git config user.name
git config user.email


- 초기화
git init

- 리모트 저장소 등록 (깃허브에 있다)
git remote add origin https://github.com/계정/레파지토리.git

- 스테이지에 추가 및 commit(저장소에 등록)
git add --all
git commit -m "메세지" 

- 업로드
git push -u origin master


- fetch(서버에가 임의 수정 되었을때)
git fetch origin
git checkout master
git merge origin/master
--- 수정내용 직접 확인 후 ---
git add --all
git commit -m "메세지"
git push -u origin master

- 수정된 리모트 레파지토리 가져오기
git pull origin

- 수정된 
