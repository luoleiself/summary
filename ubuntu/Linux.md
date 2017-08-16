1. ls(list) [options] [dirname] // 列出目标目录中所有的子目录和文件 
    * -a / -all 列出目录下的所有文件,包含 '.' 开头的隐藏文件 
    * -A 作用和 -a 一致,但不列出 '.'(当前目录)和 '..'(当前目录的父目录)  
    * -color=[WHEN] 控制是否使用色彩分辨文件, WHEN = never/always/auto 
    * -l 除了文件名之外，还将文件的权限、所有者、文件大小等信息详细列出来 
    * -R(–recursive) 同时列出所有子目录层 
    * -S 根据文件大小排序
2. cd [dirname] // 切换当前目录至指定目录 
    * / 进入系统根目录
    * .. 返回上一级目录
    * ~ 返回到上次打开的目录
3. pwd [options] 查看'当前工作目录'的完整路径,默认是链接路径  // pwd
    * -P 输出物理路径  pwd -P => /etc/rc.d/init.d
    * -L 输出链接路径  pwd -L => /etc/init.d
4. mkdir [options] [dirname] 创建指定名称的目录 
    * -m，--mode=模式 设定权限  // mkdir -m 744 /test1 
    * -p，--parents 递归创建多个目录(如果目录不存在)  // mkdir -p /test11/test111/test1111 
    * -v，--verbose 创建目录时显示信息 // mkdir -v /test2 
    * --version 输出版本信息并退出 
    * --help 显示帮助信息并退出  
5. rm [options] [filename/dirname]  删除指定文件和目录
    * -f，--force 忽略不存在的文件，从不给出提示 // rm -f /test1
    * -i，--interactive 进行交互式删除 // rm -i /test1
    * -r，-R，--recursive 递归删除全部目录及子目录 // rm -r /test11
    * -v，--verbose 删除目录时显示信息 // rm -v /test2
    * --version 输出版本信息并退出 
    * --help 显示帮助信息并退出 
6. rmdir [options] [dirname] 删除指定空目录 
    * -p 递归删除指定空目录 // rmdir -p /test11
    * -v，--verbose 显示指令执行过程 // rmdir -v /test3
7. mv [options] [sourceFilename/sourceDirname] [newFilename/newDirname] 移动文件或将文件改名  
    * -b 若需覆盖文件，则覆盖前先行备份 // mv -b test1.log /test1/test1.log
    * -f，--force 如果目标文件已存在则直接覆盖 // mv -f test1.log /test1/test1.log
    * -i 如果目标文件已经存在，会提示是否覆盖 // mv -i test1.log /test1/test1.log
    * -u 如果目标文件已经存在，且比源文件版本低时，才会更新 // mv -u test1.log /test1/test1.log
    * -t， --target-directory=DIRECTORY move all SOURCE arguments into DIRECTORY 指定目标目录，移动多个源文件到一个目标目录中 
8. cp [options] [sourceDirname] [newDirname] 复制指定的源文件或源目录到目标文件或目标目录中 
    * -a，--archive == -dR --preserve=all 复制目录中的所有项目 // cp -a /test1/ /test2/
    * -b 为已存在的目标文件创建备份 // cp -b test1.log /test1/test1.log 
    * -d == --no-dereference --preserve=links 
    * -f，--force (当 -n 存在时不需要此项)
    * -i，--interactive 覆盖前询问(使前面的 -n 失效)  
    * -H 跟随源文件中的命令符号连接 
    * -l，--link 链接文件而不复制 
    * -L，--dereference 总是跟随符号连接 
    * -n，--no-clobber 不要覆盖已存在的文件(使前面的 -i 失效) 
    * -P，--no-dereference 不跟随源文件中的符号连接 
    * -p == --preserve=模式、所有权、时间戳 
    * --preserve=[属性列表 保持指定的属性(默认:模式、所有权、时间戳)，可附加属性 
    * -R，-r，--recursive 复制目录及目录内的所有项目 
9. touch [options] [filename] 修改文件时间或者创建新文件 
    * -a，--time=atime，--time=access，--time=use 只更改存取时间 
    * -c，--no-create 如果该文件不存在，则不创建文档 
    * -d 使用指定的日期时间，而非现在的时间 
    * -f 忽略不予处理 
    * -m，--time=modify，--time=mtime 只更改变动时间 
    * -r 把指定文件或目录的日期时间，统统设定和参考文档或目录的日期时间相同 // touch -r test1.log test2.log
    * -t 使用指定的日期时间，而非现在的时间
10. cat [options] [filename] 显示文件内容 
    * -A，--show-all == -vET 
    * -b，--number-nonblank 对非空输出行编号 
    * -e == -vE 
    * -E，--show-ends 在每行结束处显示 $ 
    * -n，--number 对输出的所有行编号，由 1 开始 
    * -s, --squeeze-blank 有连续两行的空白行，替换为一行的空白行 
    * -t == -vT 
    * -T，--show-tabs 将跳格字符显示为 ^I 
    * -u (被忽略) 
    * -v, --show-nonprinting 使用 ^ 和 M- 引用，除了 LFD 和 TAB 之外 
11. nl [options] [filename] 计算文件中行号
    * -b a == cat -n 不论是否空行,都列出行号 
    * -b t 如有空行,则不列出行号(default)  
    * -n ln 行号在屏幕的最左边显示 
    * -n rn 行号在自己栏目的最右方显示，且不加 0 
    * -n rz 行号在自己栏目的最右方显示，且加 0 
    * -w 行号栏目占用的位数 
    * -p 在逻辑定界符处不重新开始计算 
12. more [-dlfpcsu ] [-num ] [+/ pattern] [+ linenum] [file ... ]  按页查看文件内容 
    * +n 从第 n 行开始显示 
    * -n 定义屏幕大小为 n 行 
    * +/pattern 在每个档案显示前搜索该字符串(pattern),然后从该字符串前两行之后开始显示 
    * -c 从顶部清屏，然后开始显示 
    * -d 提示，
    * -l 忽略 Ctrl + L（换页）字符 
    * -p 通过清除窗口而不是滚屏对文件进行换页 
    * -s 把连续的多个空行显示为一行 
    * -u 把文件中的下划线去掉
13. less [options] filename 对文件或者其他输出进行分页显示的工具,用法比 more 更强大
    * -b <number> 设置缓冲区的大小 
    * -e 当文件显示结束后自动离开 
    * -f 强迫打开特殊文件,例如二进制文件、目录 
    * -g 只标志最后搜索的关键词  
    * -i 忽略搜索时的大小写 
    * -m 显示类似 more 命令的百分比 
    * -N 显示每行的行号 
    * -o <filename> 将 less 输出的内容在指定文件中保存起来 
    * -Q 不使用警告音 
    * -s 显示连续多行空行为一行 
    * -S 行多长时将超出部分舍弃 
    * -x <number> 将 tab 键显示为规定的数字空格 
    * :/string 向下搜索 字符串 的功能 
    * :?string 向上搜索 字符串 的功能 
    * :n 重复前一个搜索(与 / 或 ? 有关) 
    * :N 反向重复前一个搜索(与 / 或 ? 有关) 
    * b 向后翻一页 
    * d 向后翻半页 
    * h 显示帮助页面 
    * Q 退出 less 命令 
    * u 向前滚动半页 
    * y 向前滚动一行 
    * [space] 滚动一行 
    * [enter] 滚动一页 
    * [pageDown] 向下翻动一页 
    * [pageUp] 向上翻动一页
14. head [options] filename 显示档案的开头到标准输出中,默认显示 10 行 
    * -q 隐藏文件名 
    * -v 显示文件名 
    * -c <number> 显示指定的字节数 
    * -n <number> 显示指定的行数 
15. tail [options][filename] 显示指定文件末尾内容,不指定文件时,作输入信息处理 
    * -f 循环读取 
    * -q 不显示处理信息 
    * -v 显示详细的处理信息 
    * -c <number> 显示指定的字节数 
    * -n <number> 显示指定的行数 
    * --pid=PID 与-f合用,表示在进程ID,PID死掉之后结束 
    * -q, --quiet, --silent 从不输出给出文件名的首部  
    * -s, --sleep-interval=S 与-f合用,表示在每次反复的间隔休眠S秒 
16. chmod [-cfvR] [--help] [--version] mode file  // 用于改变文件或目录的访问权限，用它控制文件或目录的访问权限。
    * -c 当发生改变时，报告处理信息
    * -f 错误信息不输出
    * -R(recursive) 处理指定目录以及其子目录下的所有文件(递归修改)
    * -v 运行时显示详细处理信息
    * --version 显示版本信息
