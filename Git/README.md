### [README_E.md](https://github.com/luoleiself/summary/edit/master/Git/README_E.md)

### 快捷键
    * git config --global alias.co checkout  #配置快捷键
    * git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"
### git add
    * git add .   #将文件先暂存到staging area,stages new and modified,without deleted 
    * git add -A/--all  #states all
    * git add -u #states modified and deleted, without new
    * git add -i #进入互动模式
    * git add filename #新增一个文件
    * git add modify-file #修### 改过得文档也要加add,不然在commit时要加-a
### git rm #删除文件
    * git rm filename
### git mv #修改文件名，或搬移目录
    * git mv filename newfilename
### git status #查看状态
### git commit 
    * git commit -m 'commit message' #提交添加说明
    * git commit -a -m "message" #提交修改文件并添加说明
    * git commit -a -v #-v查看修改的内容
### git branch
    * git branch #列出所有的分支
    * git branch new-branch #产生新的分支
    * git branch new-branch master #master产生新的分支
    * git branch -d branch #删除分支
    * git branch -D branch #强制删除分支
    * git checkout -b new-branch #产生新分支并切换过去
    * git branch -r #列出所有repository branch 
    * git branch -a #列出所有分支
    * git branch --set-upstream master origin 	#手动建立追踪关系
### git checkout
    * git checkout branch-name #切换到branch-name 
    * git checkout master #切换到master 
    * git checkout -b new-branch master #从master建立新的分支，并切换过去
    * git checkout -b new-branch #由当前分支建立新分支
    * git checkout -b new-branch origin #由origin建立分支
    * git checkout filename #还原状态到repository状态
    * git checkout HEAD . #将所有文件都checkout出来
    * git checkout xxxx . #xxxx是commit的编号的前四位,将xxxx编号的版本checkout出来
    * git checkout – * #恢复上一次commit的状态
### git diff
    * git diff master #与master对比看哪些文件不同
    * git diff –cached #比较staging area与repository 
    * git diff tag1 tag2 #tag1与tag2比较
    * git diff tag1:file1 tag2:file2 #tag1的file1与tag2的file2比较
    * git diff #当前与staging area比较
    * git diff HEAD #当前与repository比较
    * git diff new-brach #当前与newbranch的比较
    * git diff –stat  
### git tag
    * git tag v1 ebff #为commit ebff810c462234433434323334343设置标记v1 
    * git tag 版本1 ebff #tag可以为中文
    * git tag -d 版本1 #删除标记版本1
### git log
    * git log #列出所有log 
    * git log –all 
    * git log -p #列出log及修改的内容
    * git log -p filename #将filename的log及修改内容列出来
    * git log –name-only #列出哪些文件被修改
    * git log –stat –summary #列出各个版本间的改动及行数
    * git log filename #这个文件的所有log 
    * git log directory #这个目录的所有log 
    * git log -S'FUNC（）‘ #列出由FUNC()这个字符串的log 
    * git log –no-merges #不要列出merge的log 
    * git log –since="2 weeks ago" #列出最后两周的log 
    * git log –pretty=oneline
    * git log –pretty=short
    * git log -p  #查看历史纪录以来哪几行被修改
### git show
    * git show ebff #显示commit ebff810xxxxxxxxxxx的内容
    * git show v1 #显示tag v1的修改内容
    * git show v1:hello.txt #显示tag:v1的hello.txt文件修改内容
    * git show HEAD #当前版本的修改文件
    * git show HEAD^ #前一版本所有修改的文件
    * git show HEAD~4 #前4版本的修改文件
### git reset
    * git reset --soft HEAD^ #
    * git reset --mixed HEAD^ #default
    * git reset -–hard HEAD^ #还原到前一版本
    * git reset -–hard HEAD~3
### git grep
    * git grep "hello" v1 #查找tag:v1中是否由“hello"字符串
    * git grep "hello"
### git stash
    * git stash #放进暂存区
    * git stash list #列出暂存区的文件
    * git stash pop #取出最新的一笔，并移除
    * git stash apply #取出但不移除
    * git stash clear #清除暂存区
### git merge
    * git merge #合并
### git blame
    * git blame filename #列出此文件所有commit的记录
### git ls-files
    * git ls-files -d #查看已删除的文件
    * git ls-files -d | xargs git checkout –#将已删除的文件还原
### git revert
    * git revert HEAD #回到前一此commit的状态
    * git revert HEAD^ #回到上上一次的状态
### git remote
    * git remote add new-branch http://git.xxx.xx.com/project.git #增加远程repository的branch 
    * git remote show #列出现在由多少repository 
    * git remote rm new-branch #删除服务器上的新分支
    * git remote update #更新所有repository branch
### git fetch
    * git fetch origin
### git push
    * git push <远程主机名> <本地分支名>:<远程分支名>
    * git push origin：heads/xxx-branch
    * git push --all origin #推送本地的所有分支到远程仓库
### git pull
    * git pull <远程主机名> <远程分支名>:<本地分支名>
    * git pull = git fetch + git merge
    * git pull --rebase == git fetch + git rebase
    * git add --all 
    * git rebase --continue


