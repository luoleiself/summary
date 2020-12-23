# shell

## 命令

- export 导出全局变量
- declare 声明变量
- unset 删除变量
- local 声明局部变量,一般用于函数内部

## 流程控制

### 条件语句

#### if | if elif

```bash
if []
then
  echo 'hello then'
else
  echo 'hello else'
fi
if []
then
  echo 'hello then'
elif []
then
  echo 'hello elif'
else
  echo 'hello else'
fi
```

### 分支语句

#### case

```bash
case value in
reg1)
  echo 'reg1 matched...'
reg2)
  echo 'reg2 matched...'
*)
  echo 'default matched...'
esac
```

### 循环语句

#### for

```bash
for $var in value_list
do
  echo "$val"
done
for (( i=1; i < 10;i++))
do
  echo "${i}"
done
```

#### while

```bash
while condition
do
  echo 'hello while'
done
```

## 运算符

### []

- 必须在左括号的右侧和右括号的左侧各加一个空格

- 关系运算符必须要转义

### [ ] | [[ ]] 运算表达式两边必须要有空格

### \${} 用于变量替换，便于理解

```bash
A=B
echo $AB
echo ${A}B
BB
```

### $[] | $(()) 用于进行数学计算，对于浮点数是当作字符串处理

```bash
a=5;b=7;c=2
echo $((a+b*c))
19
echo $[a+b*c]
19
echo $(($a+$b*$c))
19
echo $[$a+$b*$c]
19
```

### (( )) | [[ ]] 针对数学表达式和字符串表达式的加强版，不需要对运算符进行转义

- 算术运算符，[ ] 字符串运算不需要转义

| 算术运算符 |                      说明                       |          举例           |
| :--------: | :---------------------------------------------: | :---------------------: |
|     +      |                      加法                       |     echo \$((a+b))      |
|     -      |                      减法                       |     echo \$((a-b))      |
|     \*     |                      乘法                       |     echo \$((a\*b))     |
|     /      |                      除法                       |     echo \$((a/b))      |
|     %      |                      取余                       |     echo \$((a%b))      |
|     =      |                      赋值                       |           a=b           |
|     ==     |   相等，判断两个数字是否相等，相等则返回 true   | echo $[ ${a} == \${b} ] |
|     !=     | 不相等，判断两个数字是否相等，不相等则返回 true | echo $[ ${a} != \${b} ] |

- 关系运算符

| 在 [ ] 中使用的比较符 | 在 (( )) 和 [[ ]] 中使用的比较符 |                说明                |                            举例                             |
| :-------------------: | :------------------------------: | :--------------------------------: | :---------------------------------------------------------: |
|          -eq          |                ==                |       equal 的缩写，表示相等       | [ ${a} -eq ${b} ] \| [[ ${a} == ${b} ]] \| ((${a} == ${b})) |
|          -ne          |                !=                |    not equal 的缩写，表示不相等    | [ ${a} -ne ${b} ] \| [[ ${a} != ${b} ]] \| ((${a} != ${b})) |
|          -gt          |                >                 |   greater than 的缩写，表示大于    |  [ ${a} -gt ${b} ] \| [[ ${a} > ${b}]] \| ((${a} > ${b}))   |
|          -ge          |                >=                | greater equal 的缩写，表示大于等于 |  [ ${a} -ge ${b} ] \| [[ ${a} >= ${b} ]]\|((${a} >= ${b}))  |
|          -lt          |                <                 |    least than 的缩写，表示小于     |  [ ${a} -lt ${b} ] \| [[ ${a} < ${b} ]] \| ((${a} < ${b}))  |
|          -le          |                <=                |  least equal 的缩写，表示小于等于  |  [ ${a} -le ${b} ] \| [[ ${a} <= ${b} ]]\|((${a} <= ${b}))  |

```bash
if [ $string -ne 'abc' ]
then
echo "Not equal"
else
echo "Equal"
fi
if [ $a -ge $b ]
then
echo "Greater equal"
else
echo "Not greater equal"
fi
```

- 逻辑运算符

| 在 [ ] 中使用的比较符 | 在 (( )) 和 [[ ]] 中使用的比较符 |                   说明                    |                 举例                  |
| :-------------------: | :------------------------------: | :---------------------------------------: | :-----------------------------------: |
|         赋值          |               a=10               |                   b=25                    |                                       |
|          -a           |                &&                |  与运算，两个表达式都为 true,才返回 true  | [ $a -lt 20 -a $b -gt 20 ] 返回 true  |
|          -o           |               \|\|               | 或运算，有一个表达式都为 true,则返回 true | [ $a -lt 20 -o $b -gt 100 ] 返回 true |
|           !           |                !                 |    非运算，表达式为 true,则返回 false     |         [ ! false ] 返回 true         |

```bash
a=5
b=12
if [ $a -lt 50 -a  $b -gt 8 ]
then
echo "And(-a) expr result is true"
else
echo "And(-a) expr result is false"
fi
if [ $a -lt 50 -o $b -gt 12 ]
then
echo "Or(-o) expr result is true"
else
echo "Or(-o) expr result is false"
fi
[ 10 -eq 10 -a 5 -eq 5 ]
echo $?
0
[[ 10 == 10 && 5 == 5 ]]
echo $?
0
((10 == 10 && 5 == 5))
echo $?
0
```

- 字符串运算符，[ ] 字符串运算不需要转义

| 字符串运算符 |                     说明                     |       举例       |
| :----------: | :------------------------------------------: | :--------------: |
|      =       |   检测两个字符串是否相等，相等则返回 true    | [ ${a} = ${b} ]  |
|      !=      |  检测两个字符串是否相等，不相等则返回 true   | [ ${a} != ${b} ] |
|      -z      |   检测字符串长度是否为 0，为 0 则返回 true   |   [ -z ${b} ]    |
|      -n      | 检测字符串长度是否不为 0，不为 0 则返回 true |   [ -n ${b} ]    |
|     str      | 检测字符串是否为 null，不为 null 则返回 true |     [ ${b} ]     |

```bash
a=hello
b=world
if [ a = b ]
then
echo "string a equal string b"
else
echo "string a not equal string b"
fi
[ -z ${a} ]
echo $?
1
[ -n ${a} ]
echo $?
0
```

- 文件测试运算符

| 文件测试运算符 |                                  说明                                   |          举例          |
| :------------: | :---------------------------------------------------------------------: | :--------------------: |
|       -b       |              检测文件是否是块设备文件，如果是，则返回 true              | [ -b $file ] 返回 true |
|       -c       |             检测文件是否是字符设备文件，如果是，则返回 true             | [ -c $file ] 返回 true |
|       -d       |               检测文件是否是目录文件，如果是，则返回 true               | [ -d $file ] 返回 true |
|       -f       | 检测文件是否是普通文件（既不是目录也不是设备文件），如果是，则返回 true | [ -f $file ] 返回 true |
|       -g       |             检测文件是否设置了 SGID 位，如果是，则返回 true             | [ -g $file ] 返回 true |
|       -k       |       检测文件是否设置了粘着位（stucky Bit），如果是，则返回 true       | [ -k $file ] 返回 true |
|       -p       |                检测文件是否具名管道，如果是，则返回 true                | [ -p $file ] 返回 true |
|       -u       |             检测文件是否设置了 SUID 位，如果是，则返回 true             | [ -u $file ] 返回 true |
|       -r       |                  检测文件是否可读，如果是，则返回 true                  | [ -r $file ] 返回 true |
|       -w       |                  检测文件是否可写，如果是，则返回 true                  | [ -w $file ] 返回 true |
|       -x       |                 检测文件是否可执行，如果是，则返回 true                 | [ -x $file ] 返回 true |
|       -s       |   检测文件是否为不为空（文件大小是否不为 0），如果不为 0，则返回 true   | [ -s $file ] 返回 true |
|       -e       |            检测文件(包括目录)是否存在，如果存在，则返回 true            | [ -e $file ] 返回 true |
|       -a       |     检测文件(包括目录)是否存在(此命令已废弃)，如果存在，则返回 true     | [ -e $file ] 返回 true |

```bash
if [ -e .node ]
then
echo 'this file is exists'
else
echo 'this file not exists'
fi
if [ -s .zshrc ]
then
echo 'file not empty'
else
echo 'file is empty'
fi
```
