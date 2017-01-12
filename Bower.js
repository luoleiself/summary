1、什么是Bower
	Bower是一个客户端技术的软件包管理器,用于搜索、安装、卸载js、html、css之类的网络资源
2、特点:
	1、节省时间:对软件依赖包的版本等信息的管理
	2、脱机工作:安装软件包并可以离线使用
	3、展现客户端的依赖关系:
	4、升级简单:
3、安装:
	$ npm install -g bower //全局安装bower
	$ bower help //查看bower帮助命令
		bower <command> [<args>] [<options>]
		commands:
			cache                   Manage bower cache
	    help                    Display help information about Bower
	    home                    Opens a package homepage into your favorite browser
	    info                    Info of a particular package
	    init                    Interactively create a bower.json file
	    install                 Install a package locally
	    link                    Symlink a package folder
	    list                    List local packages
	    lookup                  Look up a package URL by name
	    prune                   Removes local extraneous packages
	    register                Register a package
	    search                  Search for a package by name
	    update                  Update a local package
	    uninstall               Remove a local package
	   Options:
	    -f, --force             Makes various commands more forceful
	    -j, --json              Output consumable JSON
	    -l, --log-level         What level of logs to report
	    -o, --offline           Do not hit the network
	    -q, --quiet             Only output important information
	    -s, --silent            Do not output anything, besides errors
	    -V, --verbose           Makes output more verbose
	    --allow-root            Allows running commands as root

