##更新说明(by guangguang) 
1.此项目ag注单拉取，包含AG平台所有注单拉取(ag视讯，ag捕鱼，ag电子，ag体育，ag街机)等    
2.针对上个版本大量bug进行修复    
3.代码优化，对原来项目存在大量重复代码进行优化，所有公用代码进行抽象，新增平台无需关注ftp，只需实现service，拉取到的下注数据插入数据库库即可    
4.日志分离，每个游戏类型都有自己的log  
5.视讯游戏类型已经放到配置文件，但是新增游戏类型，重启才生效，(后期加入spring cloud 功能，即可实现不重启生效)  


##未来版本优化方向
1.使用quartz实现分布式定时任务  

##如何部署 
1.如果使用IDE，直接运行Main类即可  
2.如果部署到服务器上，则使用maven install的方式打包，默认配置文件并不放在jar包内，需要把配置文件单独copy到服务器上,启动命令：  
java -jar xxxx-exec.jar --spring.config.location=application.yml  --logging.config=logback-spring.xml  
或者守护执行：nohup java -jar xxxx-0.0.1-SNAPSHOT-exec.jar --spring.config.location=application.yml  --logging.config=logback-spring.xml >/dev/null 2>&1 &

## 版本更新说明：
dev-001:修复数据库插入失败不报错的bug
dev-002:record记录表加时间字段和文件大小字段