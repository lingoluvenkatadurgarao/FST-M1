import pytest

@pytest.fixture
def wallet_amount():
    amount = 0
    return amount
@pytest.mark.parametrize("earned,spent,expected",[(30,10,20),(20,2,18)])
def test_walletTransactions(wallet_amount,earned,spent,expected):
    #My wallet initially has 0
    assert wallet_amount == 0
    #I add {earned} units of cash to the wallet
    wallet_amount += earned
    #I spend {spent} units of cash
    wallet_amount -= spent
    #I should have {expected} units of cash remaining after the two transactions.
    assert wallet_amount == expected



