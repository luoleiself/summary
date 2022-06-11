"插入模式,括号自动匹配添加
"inoremap ( ()<LEFT> 
"inoremap { {}<LEFT> 
"inoremap [ []<LEFT> 
"inoremap { {<CR>}<ESC>ko 
 
"nnoremap 普通模式快捷键
"v[nore]map 可视模式快捷键 
"i[nore]map 插入模式快捷键
"x[nore]map 可视模式快捷键
"s[nore]map 选择模式快捷键
"c[nore]map 命令行模式快捷键
":unmap 
":mapclear 

"普通模式,切换窗口快捷键
noremap <C-h> <C-w><C-h>
noremap <C-j> <C-w><C-j>
noremap <C-k> <C-w><C-k>
noremap <C-l> <C-w><C-l>

"g 全局环境变量
"l 局部环境变量
"b 当前缓冲区
"w 当前窗口
"t 当前标签页
"s vim脚本文件中的局部文件作用域
"a 函数的参数


syntax on
filetype on
"colorscheme monokai
set number
"set relativenumber "显示相对行号
set autoindent
set smartindent
set showmatch

set hlsearch  " 高亮搜索
set incsearch " 增量式搜索
":noh "取消搜索结果的高亮
":set ic "不区分大小写 ignorecase

set foldmethod=indent " 开启智能缩进
set tabstop=2
set softtabstop=2
set shiftwidth=2

set history=500
set fenc=utf-8

set confirm
set expandtab
set completeopt=preview,menu

"vim-plug
"curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
" https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim
call plug#begin()
  Plug 'preservim/nerdtree'

  " :CocInstall coc-html # install extensions
  " :CocList extensions # show extensions list
  " :CocUninstall coc-html # uninstall extensions
  " :CocUpdate # update extensions
  Plug 'neoclide/coc.nvim', {'branch': 'release'} 

  Plug 'jiangmiao/auto-pairs'

  " LeaderF
  Plug 'Yggdroot/LeaderF', {'do': ':LeaderfInstallCExtension'} 
 
  " nerdcommenter
  Plug 'preservim/nerdcommenter' 
  
  Plug 'tpope/vim-fugitive'
  " set laststatus=2
  " set statusline=%<%f\ %h%m%r%{FugitiveStatusline()}%=%-14.(%l,%c%V%)\ %P
call plug#end()

" NERDTree
" Key Bindings
" C: change tree root to the selected dir
" U: move tree root up a dir but leave old root open
" u: move tree root up a dir
" r: refresh cursor dir
" R: refresh current root
" K: go to first child
" J: go to last child
" A: zoom (maximize-minimize) the NERDTree window
" o: open in prev window
" go: preview
" t: open in new tab
" T: open in new tab silently
" i: open split
" gi: preview split
" s: open vsplit
" gs: preview vsplit
" toggle sideBar tree
" 普通模式非递归快捷键
" map 递归快捷键
noremap <C-b> :NERDTreeToggle<CR>  

" coc.nvim 
" use <tab> for trigger completion and navigate to the next complete item
" if use nvm to manage Node versions, must be to set nvm alias default, otherwise will be reported error Node cannot be found
function! s:check_back_space() abort
  let col = col('.') - 1
  return !col || getline('.')[col - 1]  =~ '\s'
endfunction
inoremap <silent><expr> <Tab>
      \ pumvisible() ? "\<C-n>" :
      \ <SID>check_back_space() ? "\<Tab>" :
      \ coc#refresh()

" auto-pairs
" 
 
" LeaderF 
" :help leaderF # 帮助文档
" :Leaderf file                search files
" :Leaderf buffer              search buffers
" :Leaderf line                search a line in the buffer
" :Leaderf tag                 navigate tags using the tags file
" :Leaderf function            navigate functions or methods in the buffer
" :Leaderf mru                 search most recently used files
" :Leaderf searchHistory       execute the search command in the history
" :Leaderf cmdHistory          execute the command in the history
" :Leaderf help                navigate the help tags
" :Leaderf colorscheme         switch between colorschemes
" :Leaderf gtags               navigate tags using the gtags
" :Leaderf self                execute the commands of itself
" :Leaderf bufTag              navigate tags in the buffer
" :Leaderf rg                  grep using rg
" :Leaderf filetype            navigate the filetype
" :Leaderf command             execute built-in/user-defined Ex commands.
" :Leaderf window              search windows.
" :Leaderf quickfix            navigate the quickfix.
" :Leaderf loclist             navigate the location list.
"
" <Tab> switch between INPUT mode and NORMAL mode
" " <CR>/<double-click>/o : open file under cursor
" " x : open file under cursor in a horizontally split window
" " v : open file under cursor in a vertically split window
" " t : open file under cursor in a new tabpage
" " i/<Tab> : switch to input mode
" " s : select multiple files
" " a : select all files
" " c : clear all selections
" " p : preview the file
" " q : quit
" " <F5> : refresh the cache
" " <F1> : toggle this help   
"
" <c-r> switch between fuzzy search mode and REGEX mode
" <c-f> switch between FULL PATH search mode and NAME ONLY search mode
" <c-p> preview the result in the INPUT mode
" <c-x> open in horizontal split window
" <c-]> open in vertical split window
" <c-t> open in new tabpage
" <c-j> move the cursor downward in the result window. Or use <tab> change the NORMAL mode then use end move the cursor 
" <c-k> move the cursor upward in the result window. Or use <tab> change the NORMAL mode then use home move the cursor
" let g:Lf_WindowHeight = 0.5
" popup mode
let g:Lf_WindowPosition = 'popup' " 设置全局变量
let g:Lf_PreviewInPopup = 1
let g:Lf_StlSeparator = { 'left': "\ue0b0", 'right': "\ue0b2", 'font': "DejaVu Sans Mono for Powerline" }
let g:Lf_PreviewResult = {'Function': 0, 'BufTag': 0 }
" Change the default mapping of searching files command
let g:Lf_ShortcutF = '<C-F>' 
" Show icons, icons are shown by default
let g:Lf_ShowDevIcons = 0

" nerdcommenter
" mapleader key default '\'
let mapleader = "," " 设置先导键
" Add spaces after comment delimiters by default
let g:NERDSpaceDelims = 1 " 设置全局变量
let g:NERDDefaultAlign = 'left'
let g:NERDCustomDelimiters = {
    \ 'javascript': { 'left': '//', 'leftAlt': '/**', 'rightAlt': '*/' },
    \ 'typescript': { 'left': '//', 'leftAlt': '/**', 'rightAlt': '*/' },
    \ 'less': { 'left': '/*', 'right': '*/' },
    \ 'scss': { 'left': '/*', 'right': '*/' },
    \ 'html': { 'left': '<!--','right': '-->' },
    \ 'sh': { 'left': '#' }
 \ }
" :help nerdcommenter # 帮助文档
" <leader>cc # Comment out the current line or text selected in visual mode. 行注释
" <leader>cn # Same as cc but forces nesting. 嵌套添加注释
" <leader>cm # Comments the given lines using only one set of multipart delimiters. 块注释
" <leader>cu # Uncomments the selected line(s). 取消注释
" <leader>c$ # Comments the current line from the cursor to the end of line. 光标所在位置注释到行尾
" <leader>ci # Toggles the comment state of the selected line(s) individually. 状态切换
" <leader>cs # Comments out the selected lines with a pretty block formatted layout. 使用性感模式注释
" <leader>cy # Same as cc except that the commented line(s) are yanked first. 先复制后注释


" vim-fugitive
" :Gremove # Like :Gdelete, but keep the (now empty) buffer around.
" :Gdelete # Wrapper around git -rm that deletes the buffer afterward.
" :Gmove # Wrapper around git -mv that renames the buffer afterward.
" :Grename # Like :Gmove but operates relative to the parent directory of the current file.
" :Gbrowse # Open the current file, blob, tree, commit or tag in your browser.
" :Gdiff 
" :Gsdiff
" :Gvdiff
" :Gread # git checkout -- filename
" :Gwrite # git add 
" :Git commit
" :Git merge
" :Git rebase
" :Git revert
" :Git push
" :Git fetch
" :Git pull
" :Git blame
" :Git log
" :Git status
" :Ggrep 

