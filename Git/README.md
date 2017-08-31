### [README_E.md](https://github.com/luoleiself/summary/blob/master/Git/README_E.md)
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
  * git commit --amend -m 'message'   # 如果代码没有任何新变化，则用来改写上一次 `commit` 的提交信息   
  * git commit --amend [file1] [file2] ...    # 重做上一次 `commit`，并包括指定文件的新变化                                
### 分支
  * git branch    # 列出本地所有分支
  * git branch -r    # 列出所有远程分支
  * git branch -a    # 列出所有本地分支和远程分支
  * git branch [branch-name]    # 新建一个分支，但依然停留在当前分支
  * git branch [branch-name] [master]    # 
  * git checkout -b [branch]    # 新建一个分支，并切换到新分支
  * git branch [branch] [commit]    # 新建一个分支，指向指定 `commit`
  * git branch --track [branch] [remote-branch]    # 新建一个分支，与指定的远程分支建立追踪关系
  * git checkout [branch-name]    # 切换到指定分支，并更新工作区
  * git branch --set-upstream [branch] [remote-branch]   # 建立追踪关系，在现有分支与指定的远程分支之间
  * git merge [branch]    # 合并指定分支到当前分支
  * git cherry-pick [commit]    # 选择一个 `commit`，合并进当前分支
  * git branch -d [branch-name]    # 删除分支
  * git branch -D [branch-name]    # 强制删除分支
  * git push origin --delete [branch-name]    # 删除远程分支
  * git branch -dr [remote/branch]    # 删除远程分支
### 标签 
  * git tag    # 列出所有tag
  * git tag [tag]    # 新建一个 `tag`，在当前 `commit` 上
  * git tag [tag] [commit]    # 新建一个 `tag`，在指定 `commit` 上
  * git show [tag]    # 查看 `tag` 信息
  * git push [remote] [tag]    # 提交指定 `tag`
  * git push [remote] --tags    # 提交所有 `tag`
  * git checkout -b [branch] [tag]    # 新建一个分支，指向某个 `tag`
### 查看信息
  * git status    # 显示有变更的文件
  * git log    # 显示当前分支的历史版本
  * git log --stat    # 显示 `commit` 历史，以及每次 `commit` 发生变更的文件
  * git log --follow [file]    # 显示某个文件的版本历史，包括文件改名
  * git whatchanged [file]    # 显示某个文件的版本历史，包括文件改名
  * git log -p [file]    # 显示指定文件相关的每一次 `diff`
  * git blame [file]    # 显示指定文件是什么人什么时候修改过   
  * git diff    # 显示暂存区和工作区的差异
  * git diff --cached [file]    # 显示暂存区和上一个 `commit` 的差异   
  * git diff HEAD    # 显示工作区与当前分支最新 `commit` 之间的差异
  * git diff [first-branch] ... [second-branch]    # 显示两次提交之间的差异
  * git show [commit]    # 显示某次提交的元数据和内容变化
  * git show --name-only [commit]    # 显示某次提交发生变化的文件
  * git show [commit]:[filename]    # 显示某次提交时，某个文件的内容
  * git reflog    # 显示当前分支的最近几次提交                      
### 远程同步
  * git fetch [remote]    # 下载远程仓库的所有变动
  * git remote -v    # 显示所有远程仓库
  * git remote show [remote]    # 显示某个远程仓库的信息 
  * git remote add [shortname] [url]    # 增加一个新的远程仓库，并命名
  * git pull [remote] [branch]    # 取回远程仓库的变化，并与本地分支合并
  * git push [remote] [branch]    # 上传本地指定分支到远程仓库
  * git push [remote] --force    # 强行推送当前分支到远程仓库，即使有冲突
  * git push [remote] --all    # 推送所有分支到远程仓库
  * git push origin local_branch:origin_branch   # 推送本地分支到远程分支,如果远程分支不存在则新建
### 撤销
  * git checkout [file]    # 恢复暂存区的指定文件到工作区
  * git checkout [commit] [file]    # 恢复某个 `commit` 的指定文件到工作区
  * git checkout .    # 恢复上一个 `commit` 的所有文件到工作区
  * git reset [file]    # 重置暂存区的指定文件，与上一次 `commit` 保持一致，但工作区不变
  * git reset --hard    # 重置暂存区和工作区，与上一次 `commit` 保持一致
  * git reset [commit]    # 重置当前分支的指针为指定 `commit` ，同时重置暂存区，但工作区不变
  * git reset --hard [commit]    # 重置当前分支的HEAD为指定 `commit`，同时重置暂存区和工作区，与指定commit一致
  * git reset --keep [commit]    # 重置当前HEAD为指定 `commit`，但保持暂存区和工作区不变
  * git reset --soft HEAD^    # 还原版本库到上一个版本  
  * git reset --mixed HEAD^    # default,还原版本库、暂存区到上一个版本  
  * git reset -–hard HEAD^    # 还原版本库、暂存区、工作区到上一个版本  
  * git reset -–hard HEAD~3    # 还原到第三个版本  
  * git revert [commit]    # 新建一个 `commit`，用来撤销指定 `commit`
  * git revert [commit]    # 后者的所有变化都将被前者抵消，并且应用到当前分支
  * git revert HEAD    # 回到前一此 `commit` 的状态
  * git revert HEAD^    # 回到上上一次的状态
### 其他
  * git archive    # 生成一个可供发布的压缩包
  * git stash #放进暂存区
  * git stash list #列出暂存区的文件
  * git stash pop #取出最新的一笔，并移除
  * git stash apply #取出但不移除
  * git stash clear #清除暂存区

