### [README_E.md](https://github.com/luoleiself/summary/edit/master/Git/README_E.md)
### 新建代码库
  * git init   # 在当前目录新建一个 `Git` 代码仓库
  * git init [project-name]   # 新建一个目录，将其初始化为 `Git` 代码库
  * git clone [url]   # 下载一个项目和它的整个代码历史
### 配置
  * git config -l/--list   # 显示当前的 `Git` 配置
  * git config -e [--global]   # 编辑 `Git` 配置文件
  * git config [--global] user.name '[name]'  # 设置提交代码时的用户信息-用户名
  * git config [--global] user.email '[email address]'  # 设置提交代码时的用户信息-邮箱
  * git config --global alias.co checkout  # 配置 `checkout` 快捷键
  * git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"  # 配置 `log` 快捷键和显示历史颜色 
### 增加/删除文件
  * git add [file1] [file2] ...   # 添加到指定文件到暂存区
  * git add [dir]   # 添加指定目录到暂存区，包括子目录
  * git add . == git add -A/--all   #  添加当前目录的所有文件到暂存区
  * git add -i   # 进入互动模式
  * git rm [file1] [file2] ...   # 删除工作区文件，并将这次删除操作添加到暂存区
  * git rm --cached [file]    # 停止追踪指定文件，但该文件会保留在工作区
  * git mv [file-original] [file-renamed]  # 文件重命名，并将此次操作添加到暂存区  
### 代码提交
  * git commit -m 'message'  # 提交暂存区到仓库区
  * git commit [file1] [file2] ... -m 'message'   # 提交暂存区的指定文件到仓库区
  * git commit -a    # 提交工作区自上次 `commit` 之后的变化，直接到仓库区
  * git commit -v    # 提交时显示所有 `diff` 信息
  * git commit --amend -m 'message'   # 使用一次新的 `commit`，替代上一次提交
  *                                   # 如果代码没有任何新变化，则用来改写上一次 `commit` 的提交信息   
  * git commit --amend [file1] [file2] ...    # 重做上一次 `commit`，并包括指定文件的新变化                                
### 分支
  * 














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
    * git reset --soft HEAD^   #  还原版本库到上一个版本  
    * git reset --mixed HEAD^ #  default,还原版本库、暂存区到上一个版本  
    * git reset -–hard HEAD^  #  还原版本库、暂存区、工作区到上一个版本  
    * git reset -–hard HEAD~3 #  还原到第三个版本  
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


