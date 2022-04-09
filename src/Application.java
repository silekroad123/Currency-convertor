import test.convert.TestFiatToFiat;
import test.convert.TestFiatToGold;
import test.convert.TestFiatToHash;
import test.convert.TestFiatToNft;
import test.transfer.TestBlockedWallet;
import test.transfer.TestDifferentAccount;
import test.transfer.TestExceededLimit;
import test.transfer.TestSameAccount;

public class Application {

    public static void main(String[] args){
        TestFiatToFiat.initDialog();
        TestFiatToGold.initDialog();
        TestFiatToHash.initDialog();
        TestFiatToNft.initDialog();
        TestSameAccount.initDialog();
        TestDifferentAccount.initDialog();
        TestExceededLimit.initDialog();
        TestBlockedWallet.initDialog();
    }
}
