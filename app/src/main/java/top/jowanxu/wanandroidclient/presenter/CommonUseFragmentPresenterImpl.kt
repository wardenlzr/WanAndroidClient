package top.jowanxu.wanandroidclient.presenter

import top.jowanxu.wanandroidclient.bean.FriendListResponse
import top.jowanxu.wanandroidclient.bean.HotKeyResponse
import top.jowanxu.wanandroidclient.model.HomeModel
import top.jowanxu.wanandroidclient.model.HomeModelImpl
import top.jowanxu.wanandroidclient.view.CommonUseFragmentView

class CommonUseFragmentPresenterImpl(private val commonUseFragmentView: CommonUseFragmentView) : HomePresenter.OnFriendListListener {

    private val homeModel: HomeModel = HomeModelImpl()
    /**
     * get friend tree list
     */
    override fun getFriendList() {
        homeModel.getFriendList(this)
    }

    /**
     * get friend list success
     * @param result result
     */
    override fun getFriendListSuccess(result: FriendListResponse, hotResult: HotKeyResponse) {
        if (result.errorCode != 0) {
            commonUseFragmentView.getFriendListFailed(result.errorMsg)
            return
        }
        if (result.data.isEmpty()) {
            commonUseFragmentView.getFriendListZero()
            return
        }
        commonUseFragmentView.getFriendListSuccess(result, hotResult)
    }

    /**
     * get friend list failed
     * @param errorMessage error message
     */
    override fun getFriendListFailed(errorMessage: String?) {
        commonUseFragmentView.getFriendListFailed(errorMessage)
    }

    /**
     * cancel request
     */
    fun cancelRequest() {
        homeModel.cancelHomeListRequest()
    }
}