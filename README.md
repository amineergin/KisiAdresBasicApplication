# KisiAdresBasicApplication
- Uygulama kişiler ve adresler arasında one-to-many ilişkisi olduğu kabul edilerek geliştirilmiş bir spring boot - postgresql projesidir.
- Uygulamayı çalıştırabilmek için bilgisayarınızda java jdk ve docker kurulumu yapılmış olmalıdır.
- Postgresql docker kullanılarak ayağa kaldırılmış olup, komut istemcisinde projenin src/main/resources yoluna gidilmeli ve şu kodlar yazılmalıdır: 'docker-compose -f docker-compose.yml up -d'. Bu aşamada docker desktop'ın hali hazırda bilgisayarınızda açık olması gerektiğini unutmayınız.
- Komut istemcisinden başarılı geri dönüşü aldıktan sonra, Intellij Idea'nın sağ tarafında bulunan database ikonuna tıklayın. Daha sonra + butonundan postgresql'i seçin. Gelen Query Console'da create database databaseName; yazın ve çalıştırın. Burda verdiğiniz veritabanı ismi application.proporties dosyasında verdiğiniz veritabanı ismi olacaktır. Daha sonra komut isteminde 'for /F %i in ('docker ps -q') do docker stop %i' kodları ile docker'ı durdurun ve 'docker-compose -f docker-compose.yml up -d' kodları ile yeniden ayağa kaldırın.
- Bu aşamalardan sonra veritabanı bağlantılarınız tamamlanmış olacaktır.
- Herhangi bir sorunuz olursa sormaktan çekinmeyin. 
