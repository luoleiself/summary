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
16. which [可执行文件名称] 在 PATH 变量指定的路径中,搜索系统命令的位置并返回结果
    * -n 指定文件名长度，指定的长度必须大于或等于所有文件中最长的文件名 
    * -p 与-n参数相同，但此处的包括了文件的路径 
    * -w 指定输出时栏位的宽度 
    * -V 显示版本信息 
17. whereis [-bmsu] [BMS 目录名 -f ] 文件名 定位可执行文件、源代码文件、帮助文件在文件系统中的位置,这些文件的属性应属于原始代码，二进制文件，或是帮助文件,原理和 locate 原理类似,效率比 find 高
    * -b  定位可执行文件。
    * -m  定位帮助文件。
    * -s  定位源代码文件。
    * -u  搜索默认路径下除可执行文件、源代码文件、帮助文件以外的其它文件。
    * -B  指定搜索可执行文件的路径。
    * -M  指定搜索帮助文件的路径。
    * -S  指定搜索源代码文件的路径
18. Locate [选择参数] [样式] 配合数据库查看文件位置,其方法是先建立一个包括系统内所有档案名称及路径的数据库，之后当寻找时就只需查询这个数据库，而不必实际深入档案系统之中了
    * -e 将排除在寻找的范围之外。
    * -1 如果 是 1．则启动安全模式。在安全模式下，使用者不会看到权限无法看到	的档案。这会始速度减慢，因为 locate 必须至实际的档案系统中取得档案的	权限资料。
    * -f 将特定的档案系统排除在外，例如我们没有到理要把 proc 档案系统中的档案	放在资料库中。
    * -q 安静模式，不会显示任何错误讯息。
    * -n 至多显示 n个输出。
    * -r 使用正规运算式 做寻找的条件。
    * -o 指定资料库存的名称。
    * -d 指定资料库的路径
    * -h 显示辅助讯息
    * -V 显示程式的版本讯息
19. find pathname -options [-print -exec -ok ...] 用于在文件树种查找文件，并作出相应的处理.实际搜寻硬盘查询文件名称
    * pathname: find命令所查找的目录路径。例如用.来表示当前目录，用/来表示系统根目录。 
    * -print：find命令将匹配的文件输出到标准输出。 
    * -exec：find命令对匹配的文件执行该参数所给出的shell命令。相应命令的形式为'command' {  } \;，注意{   }和\；之间的空格。 
    * -ok：和-exec的作用相同，只不过以一种更为安全的模式来执行该参数所给出的shell命令，在执行每一个命令之前，都会给出提示，让用户来确定是否执行。
    * -name   按照文件名查找文件。
    * -perm   按照文件权限来查找文件。
    * -prune  使用这一选项可以使find命令不在当前指定的目录中查找，如果同时使用-depth选项，那么-prune将被find命令忽略。
    * -user   按照文件属主来查找文件。
    * -group  按照文件所属的组来查找文件。
    * -mtime -n +n  按照文件的更改时间来查找文件， - n表示文件更改时间距现在n天以内，+ n表示文件更改时间距现在n天以前。find命令还有-atime和-ctime 选项，但它们都和-m time选项。
    * -nogroup  查找无有效所属组的文件，即该文件所属的组在/etc/groups中不存在。
    * -nouser   查找无有效属主的文件，即该文件的属主在/etc/passwd中不存在。
    * -newer file1 ! file2  查找更改时间比文件file1新但比文件file2旧的文件。
    * -type  查找某一类型的文件，诸如：
    * b - 块设备文件。
    * d - 目录。
    * c - 字符设备文件。
    * p - 管道文件。
    * l - 符号链接文件。
    * f - 普通文件。
    * -size n：[c] 查找文件长度为n块的文件，带有c时表示文件长度以字节计。-depth：在查找文件时，首先查找当前目录中的文件，然后再在其子目录中查找。
    * -fstype：查找位于某一类型文件系统中的文件，这些文件系统类型通常可以在配置文件/etc/fstab中找到，该配置文件中包含了本系统中有关文件系统的信息。
    * -mount：在查找文件时不跨越文件系统mount点。
    * -follow：如果find命令遇到符号链接文件，就跟踪至链接所指向的文件。
    * -cpio：对匹配的文件使用cpio命令，将这些文件备份到磁带设备中。
    * 另外,下面三个的区别:
    * -amin n   查找系统中最后N分钟访问的文件
    * -atime n  查找系统中最后n*24小时访问的文件
    * -cmin n   查找系统中最后N分钟被改变文件状态的文件
    * -ctime n  查找系统中最后n*24小时被改变文件状态的文件
    * -mmin n   查找系统中最后N分钟被改变文件数据的文件
    * -mtime n  查找系统中最后n*24小时被改变文件数据的文件
20. chmod [-cfvR] [--help] [--version] mode file  // 用于改变文件或目录的访问权限，用它控制文件或目录的访问权限。
    * -c 当发生改变时，报告处理信息
    * -f 错误信息不输出
    * -R(recursive) 处理指定目录以及其子目录下的所有文件(递归修改)
    * -v 运行时显示详细处理信息
    * --version 显示版本信息
21. tar[必要参数][选择参数][文件]  压缩和解压文件
    * -A 新增压缩文件到已存在的压缩 
    * -B 设置区块大小 
    * -c 建立新的压缩文件 
    * -d 记录文件的差别 
    * -r 添加文件到已经压缩的文件
    * -u 添加改变了和现有的文件到已经存在的压缩文件
    * -x 从压缩的文件中提取文件
    * -t 显示压缩文件的内容
    * -z 支持gzip解压文件
    * -j 支持bzip2解压文件
    * -Z 支持compress解压文件
    * -v 显示操作过程
    * -l 文件系统边界设置
    * -k 保留原有文件不覆盖
    * -m 保留文件不被覆盖
    * -W 确认压缩文件的正确性 
    * -b 设置区块数目
    * -C 切换到指定目录
    * -f 指定压缩文件
    * --help 显示帮助信息
    * --version 显示版本信息
