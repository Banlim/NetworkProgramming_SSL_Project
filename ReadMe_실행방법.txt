0. ������ �ϱ� �� �ڵ� ����
SSL_Server.java ���� 58, 59��° �� root, ksName ������ �ٲ��־�� �մϴ�.
������Ʈ ���� ���� directory�� keystore directory �ȿ� MySSLServerKey ������ �����մϴ�.
(���ٸ� 7�� �ǽ��� ������ ���� ����� �����ϰ� �����Ͽ� ����� �ָ� �˴ϴ�.)
�� ������ �ִ� ��η� ������ ������ �ٲ��ּ���.
(...>NetworkProject>bin>keystore>MySSLServerKey)
���Ҿ� 68, 69��° ���� keyStorePass, keyPass ������ �ٲ��־�� �մϴ�. (�ش� ���ڿ����� ��й�ȣ�� �����ϸ� �ȴ�)

1. ������ ���
   1) cmd>...(������Ʈ ������ ����� ���)>NetworkProject>src
   2) javac Client_Interface.java 
   3) javac ButtonEventListener.java
   4) javac SSL_Server.java
   5) javac SSL_Client.java
   6) javac ServerThread.java
   7) javac openFilePath.java
   8) javac HandleWordTextWindow.java
   9) cd ./RMI
   10) javac HandleWordText.java
   11) javac MyHighLightPainter.java
   12) cd ..

2. ���� ���
   1) cmd â�� 2�� ����, cmd>...(������Ʈ ������ ����� ���)>NetworkProject>src�� �̵��Ѵ�.
   2) start rmiregistry [Enter]
   3) java SSL_Server 5533 [Enter]
   4) �ٸ� cmd â�� java Client_Interface [Enter]
   5) ���ε� ��ư�� ������ ...>NetworkProject>bin>trustedcerts ������ ����.
   6) server address : localhost, server port : 5533, username : [������ �̸�] �� �Է��� �� ���� ��ư�� ������.
(����, SSLHandshakeException�� �߻��Ѵٸ� java�� ���� ������ java.security ���Ͽ��� java.tls.disabled �Ǿ� �ִ� �κ��� ��Ȱ��ȭ �����־� handshake�� ����� �� �ִ� ȯ���� ����� �ݴϴ�.)
   7) ���� ��ư�� ������ ���ο� â�� ��Ÿ����.
   8) upload ��ư�� ������ ������ txt ������ ����.
   9) �˻�â�� ������ �ܾ �Է��� �� search ��ư�� Ŭ���Ѵ�.
   10) search ��ư�� �ش� �ܾ �����ϴ� ���� highlight�� �Ǹ�, ��Ͽ� ���´�.

3. ���� ����
   1) SSL_Server ������ ���� Client�� ���� ������ ���·� ����� ���´�.
   2) Client_Interface ������ ���� ����ڰ� �Է°��� ���� �� �ִ� â�� �����ȴ�.
   3) Interface â���� ���ε� ��ư�� ���� ...>bin>trustedcerts ������ ���ε� �Ѵ�.
   4) Interface â���� �����ּ�, port, username�� �Է��ϰ� ���� ��ư�� ������ ������ SSL ����� �� �� �ְ� �ȴ�.
   5) ���� ��ư �̺�Ʈ�� �߻��ϸ�, ���ο� â�� ��Ÿ����, upload ��ư�� ���� txt ������ ����.
   6) text������ ���� textArea�� ���� ����� ���� ������ �ԷµǴ� �Ͱ� �ܾ� �˻� �� ����ϴ� ������ rmi�� ���� �����Ͽ���. 
