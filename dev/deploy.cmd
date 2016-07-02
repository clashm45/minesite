@echo off
echo remove domain1/autodeploy/.war starting...
rm C:\glassfish-4.1\glassfish4\glassfish\domains\domain1\autodeploy\restExsample.war
echo finish!
echo move newer web war starting...
mv build\libs\restExsample.war C:\glassfish-4.1\glassfish4\glassfish\domains\domain1\autodeploy\restExsample.war
echo finish!

echo =====
ls build\libs
echo =====
ls C:\glassfish-4.1\glassfish4\glassfish\domains\domain1\autodeploy
