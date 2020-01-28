import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import javax.crypto.KeyAgreement;
import java.security.spec.*;

public class Sec {
  public static void main(String[] args) {
    // Bob和Alice:
    Person bob = new Person("Bob");
    Person alice = new Person("Alice");

    // 各自生成KeyPair:
    bob.generateKeyPair();
    alice.generateKeyPair();

    // 双方交换各自的PublicKey:
    // Bob根据Alice的PublicKey生成自己的本地密钥:
    bob.generateSecretKey(alice.publicKey.getEncoded());
    // Alice根据Bob的PublicKey生成自己的本地密钥:
    alice.generateSecretKey(bob.publicKey.getEncoded());

    // 检查双方的本地密钥是否相同:
    bob.printKeys();
    alice.printKeys();
    // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...
  }
}

class Person {
  public final String name;

  public PublicKey publicKey;
  private PrivateKey privateKey;
  private byte[] secretKey;

  public Person(String name) {
    this.name = name;
  }

  // 生成本地KeyPair:
  public void generateKeyPair() {
    try {
      KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
      kpGen.initialize(512);
      KeyPair kp = kpGen.generateKeyPair();
      this.privateKey = kp.getPrivate();
      this.publicKey = kp.getPublic();
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  public void generateSecretKey(byte[] receivedPubKeyBytes) {
    try {
      // 从byte[]恢复PublicKey:
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
      KeyFactory kf = KeyFactory.getInstance("DH");
      PublicKey receivedPublicKey = kf.generatePublic(keySpec);
      // 生成本地密钥:
      KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
      keyAgreement.init(this.privateKey); // 自己的PrivateKey
      keyAgreement.doPhase(receivedPublicKey, true); // 对方的PublicKey
      // 生成SecretKey密钥:
      this.secretKey = keyAgreement.generateSecret();
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  public void printKeys() {
    System.out.printf("Name: %s\n", this.name);
    System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
    System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
    System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
  }
}
