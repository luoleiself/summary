   
	* git config --global alias.st status        //给status配置别名
	* git config --global alias.co checkout
	* git config --global alias.ci commit
	* git config --global alias.br branch 
	* git config --global alias.lg "log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit"
	* git log        //命令是查看全部提交日志  
	* git log -2        //查看最近2次的提交日志  
	* git log -p        //查看历史纪录以来哪几行被修改  
	* git log --stat --summary        //查看每个版本变动的档案和行数 
	* git remote add origin git@github.com:michaelliao(github账号)/learngit.git        //关联远程库origin
	* git remote	-v        //查看远程信息，参数-v显示更详细的信息
	* git remote rm origin        //修改remote
   	* git branch --set-upstream master origin  //手动建立追踪关系  
	* git pull <远程主机名> <远程分支名>:<本地分支名>
	* git push <远程主机名> <本地分支名>:<远程分支名>    
	* git push -u origin master	//把本地库的内容推送到远程，-u第一次推送，关联远程库和本地库的master分支
	* git push origin master	//推送本地库到远程库
	* git push --all origin	//所有本地分支都推送到origin主机
	* git push origin --delete master	//删除origin主机的master分支
	* git clone git@my.github.com:username/repo.git
	* git checkout -b dev	# 创建并切换分支
	* git branch -a -r -d
	* git tag <name>	# 创建标签
	* git help <command>	# 显示command的help
	* git show	# 显示某次提交的内容
	* git show $id
	* git stash apply	//但是恢复后，stash内容并不删除，你需要用git stash drop来删除；
	* git stash pop		//恢复的同时把stash内容也删了；
	* git reset <file>	# 从暂存区恢复到工作文件
	* git reset -- . 	# 从暂存区恢复到工作文件
	* git reset --hard 	# 恢复最近一次提交过的状态，即放弃上次提交后的所有本次修改
	* git diff <file> 	# 比较当前文件和暂存区文件差异
	* git diff
	* git diff <$id1> <$id2> 		# 比较两次提交之间的差异
	* git diff <branch1>..<branch2> 	# 在两个分支之间比较
	* git diff --staged 	# 比较暂存区和版本库差异
	* git diff --cached 	# 比较暂存区和工作区差异
	* git diff --stat 	# 仅仅比较统计信息
	* git diff --check 	# 它将会找到可能的空白错误并将它们为你列出来。
	* ssh-keygen -t rsa -c "youremail@example.com"  //创建SSH Key
	* ssh -T git@github.com    //测试SSH Key
