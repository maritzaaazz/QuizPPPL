import org.example.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;
    private Wallet recipientWallet;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Persiapan pengujian Wallet...");
    }

    @BeforeEach
    void setUp() {
        wallet = new Wallet(100.0, "USD");
        recipientWallet = new Wallet(50.0, "USD");
    }

    @Test
    void testGetBalance() {
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    void testGetCurrency() {
        assertEquals("USD", wallet.getCurrency());
    }

    @Test
    void testDeposit() {
        wallet.depositAmount(50.0);
        assertEquals(150.0, wallet.getBalance());
    }

    @Test
    void testDepositJumlahNegatif() {
        assertThrows(IllegalArgumentException.class, () -> wallet.depositAmount(-50.0));
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    void testWithdraw() {
        assertTrue(wallet.withdrawAmount(50.0));
        assertEquals(50.0, wallet.getBalance());
    }

    @Test
    void testWithdrawSaldoTidakCukup() {
        assertFalse(wallet.withdrawAmount(150.0));
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    void testSaldoNegatifSetelahPenarikan() {
        assertFalse(wallet.withdrawAmount(150.0));
        assertEquals(-50.0, wallet.getBalance());
    }

    @Test
    void testTransferDana() {
        wallet.transferFunds(recipientWallet, 50.0);
        assertEquals(50.0, wallet.getBalance());
        assertEquals(100.0, recipientWallet.getBalance());
    }

    @Test
    void testTransferDanaSaldoTidakCukup() {
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipientWallet, 150.0));
        assertEquals(100.0, wallet.getBalance());
        assertEquals(50.0, recipientWallet.getBalance());
    }

    @Test
    void testTransferDanaMataUangBerbeda() {
        recipientWallet = new Wallet(50.0, "EUR");
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipientWallet, 50.0));
//        assertEquals(100.0, wallet.getBalance());
        assertEquals(50.0, recipientWallet.getBalance());
    }

    @AfterEach
    void tearDown() {
        wallet = null;
        recipientWallet = null;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Pengujian Wallet selesai.");
    }
}
