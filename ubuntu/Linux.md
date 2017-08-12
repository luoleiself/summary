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
6. chmod [-cfvR] [--help] [--version] mode file  // 用于改变文件或目录的访问权限，用它控制文件或目录的访问权限。
    * -c 当发生改变时，报告处理信息
    * -f 错误信息不输出
    * -R(recursive) 处理指定目录以及其子目录下的所有文件(递归修改)
    * -v 运行时显示详细处理信息
    * --version 显示版本信息
