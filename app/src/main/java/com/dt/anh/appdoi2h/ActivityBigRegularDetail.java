package com.dt.anh.appdoi2h;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.dt.anh.appdoi2h.model.ActivityBigRegular;
import com.dt.anh.appdoi2h.model.ImgActAdapter;

import java.util.ArrayList;
import me.relex.circleindicator.CircleIndicator;

public class ActivityBigRegularDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvTitle, tvContentFirst, tvContentSecond;
    private ImageView ivContent;
    private cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager vpgAct;
    private CircleIndicator indicator;
    private ActivityBigRegular mCurrentActListing;

    private ArrayList<ActivityBigRegular> activityBigRegular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_regular_detail);

        initViews();
        initData();
        initItems();
    }

    private void initData() {
        activityBigRegular = new ArrayList<>();
        ArrayList<Integer> arrayListImg1 = new ArrayList<>();
        arrayListImg1.add(R.drawable.dem_hoi_vung_than_1);
        arrayListImg1.add(R.drawable.dem_hoi_vung_than_2);
        arrayListImg1.add(R.drawable.dem_hoi_vung_than_3);
        arrayListImg1.add(R.drawable.dem_hoi_vung_than_4);
        arrayListImg1.add(R.drawable.dem_hoi_vung_than_5);
        activityBigRegular.add(new ActivityBigRegular("Chương trình văn nghệ: “Đêm hội vùng than”",
                "\tĐêm hội vùng than là chương trình nội bộ thường niên của Đội SVTN Đồng hương Quảng Ninh.  Chương trình được tổ chức ngay sau khi đón khóa mới vào Đội. Sau những ngày lo lắng, hồi hộp, mong chờ, các em sẽ đón nhận kết quả phỏng vấn tuyển Cộng Tác viên, những người trúng tuyển sẽ chính thức trở thành CTV của Hai Hòn.",
                R.drawable.dem_hoi_vung_than_1,
                "\tKhi ấy, anh chị sẽ tổ chức cho các em một chương trình với tên \n" +
                        "gọi “Đêm hội vùng than”, Sẽ là những tiết mục văn nghệ đặc sắc, những trò chơi, phần quà hấp dẫn, những điệu nhảy zap đặc trưng thể hiện khí thế, nhiệt huyết, tinh thần sục sôi của người thanh niên tình nguyện. Chương trình chào khóa mới với mong muốn sẽ để lại trong các em, những tình nguyện mới của HAi Hòn những ấn tượng đầu tiên đẹp nhất về Đội.\n",
                arrayListImg1));

        ArrayList<Integer> arrayListImg2 = new ArrayList<>();
        arrayListImg2.add(R.drawable.thx_n);
        arrayListImg2.add(R.drawable.thx1);
        arrayListImg2.add(R.drawable.thx2);
        arrayListImg2.add(R.drawable.thx3);
        arrayListImg2.add(R.drawable.thx6);
        arrayListImg2.add(R.drawable.thx7);
        arrayListImg2.add(R.drawable.thx8);
        activityBigRegular.add(new ActivityBigRegular("Tập huấn kỹ năng tân hội viên Hội sinh viên",
                "\tTập Huấn Tân Hội Sinh viên hay tập huấn xa là chương trình lớn thứ hai được tổ chức bởi Hội Sinh viên trường Đại học Kinh tế Quốc Dân sau chương trình đón khóa mới “Bình Minh Sinh Viên”. Hưởng ứng tinh thần của Hội, năm nào Đội SVTN Đồng hương Quảng Ninh cũng tham giaTập Huấn Xa với một tinh thần tràn trề năng lượng và sục sôi nhất.",
                R.drawable.thx3,
                "\tVới tính chất là cuộc tập huấn kĩ năng cho tân sinh viên, Tập Huấn Xa luôn để lại cho các tình nguyện viên, các sinh viên những kỉ niệm và trải nghiệm không bao giờ quên được. Hai ngày một đêm cùng nhau sinh hoạt, quen biết, hiểu nhau và từ ấy tình cảm Đồng Đội trở nên khăng khít hơn. Cùng nhau hoạt động, đoàn kết và cùng thể hiện màu sắc đơn vị. Có thể nói, Tập Huấn Xa là chương trình mở đầu của những trải nghiệm mới khi các Cộng Tác viên bước vào Đội, là tiền đề cho những chương trình lớn của Đội sau này.",
                arrayListImg2));

        ArrayList<Integer> arrayListImg3 = new ArrayList<>();
        arrayListImg3.add(R.drawable.suoi_am_vung_than_1);
        arrayListImg3.add(R.drawable.suoi_am_vung_than_2);
        arrayListImg3.add(R.drawable.suoi_am_vung_than_3);
        arrayListImg3.add(R.drawable.suoi_am_vung_than_4);
        arrayListImg3.add(R.drawable.suoi_am_vung_than_5);
        arrayListImg3.add(R.drawable.suoi_am_vung_than_6);
        activityBigRegular.add(new ActivityBigRegular("Chương trình tình nguyện: “Sưởi Ấm Vùng Than”",
                "\t“Sưởi Ấm Vùng Than” , một chương trình thường niên vô cùng lớn không thể không kể đến của Đội SVTN Đồng hương Quảng Ninh. Nhắc đến “Sưởi Ấm Vùng Than” là nhắc đến những ngày đông lạnh giá, nhắc đến khoảng thời gian dài tất bật với công tác chuẩn bị chương trình. ",
                R.drawable.suoi_am_vung_than_1,
                "\tNhắc đến những chiều gió lanh cùng nhau hát hò,tập luyện văn nghệ đến khuya sân sau nhà 11, những  hôm đặt bàn khuyên góp, giới thiệu chương trình, đi truyền thông nhà dân, đi phân loại quần áo. Có lẽ, nếu ai đó hỏi về chương trình để lại ấn tượng sâu sắc nhất đối với mỗi tình nguyện viên Quảng Ninh thì câu trả lời sẽ là SƯỞI ẤM VÙNG THAN.\n" +
                "\tChuyến đi của “Sưởi Ấm Vùng Than” là những chuyến đi với trải nghiệm đậm sâu mà các Thành viên, Cộng Tác viên sẽ không bao giờ quên được. Dưới cái thời tiết giá lạnh và khắc nghiệt ở những miền xa xôi, hẻo lánh, Hai Hòn đem đến cho người dân, bà con những vùng khó khăn những món quà vật chất và tinh thần, những yêu thương và sự giúp đỡ chân thành, thắp lên ngọn lửa rực rỡ, ấm áp của mùa đông. Đã bao mùa sưởi ấm đi qua, mỗi năm đều để lại những dấu ấn nhất định trong long bà con và người dân, nới mà Đội đặt chân tới. Với hi vọng nhiều năm về sau nữa, “Sưởi Ấm Vùng Than” vẫn mãi là chương trình thiết thực, ý nghĩa và đặc trưng nhất khi nhắc đến Quảng Ninh.\n" +
                "\tBắt đầu từ năm 2012 Đội bắt đầu tổ chức chương trình \"Sưởi ấm vùng than\" tại các xã nghèo của tỉnh Quảng Ninh. Từ đó đến nay, Đội SVTN đồng hương Quảng Ninh đã đem mộ mùa đông ấm đến với người dân Kỳ Thượng - Hoành Bồ (2012), Đại Thành - Tiên Yên (2013), Đồng Lâm - Hoành Bồ (2014), Hà Lâu - Tiên Yên (2015).\n",
                arrayListImg3));

        ArrayList<Integer> arrayListImg4 = new ArrayList<>();
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_1);
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_2);
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_3);
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_4);
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_5);
        arrayListImg4.add(R.drawable.khoa_moi_chao_anh_chi_6);
        activityBigRegular.add(new ActivityBigRegular("Đêm giao lưu: “Khóa mới chào anh chị”",
                "\tSau một thời gian hoạt động Đội, trải qua một số hoạt động và chương trình, các Cộng Tác viên mới sẽ trưởng thành hơn rất nhiều. Khi ấy cũng là lúc các em ra mắt chương trình, sản phẩm đầu tiên chính tự tay các em dành cho anh chị tất cả khóa trên.\n",
                R.drawable.khoa_moi_chao_anh_chi_1,
                "\tNếu “Đêm Hội Vùng Than” là một giới thiệu, chào đón của anh chị dành cho các em thì “Khóa mới chào anh chị” như một lời đáp trả. Khóa mới chào anh chị sẽ là chương trình nội bộ đặc biệt, đánh dấu mốc son của sự nhận thức và chín chắn. Chương trình sẽ chứng minh những gì các CTV mới đã học được trong suốt thời gian đầu gắn bó và hoạt động trong Đội.\n",
                arrayListImg4));

        ArrayList<Integer> arrayListImg5 = new ArrayList<>();
        arrayListImg5.add(R.drawable.hanh_trang_si_tu_1);
        arrayListImg5.add(R.drawable.hanh_trang_si_tu_2);
        arrayListImg5.add(R.drawable.hanh_trang_si_tu_3);
        arrayListImg5.add(R.drawable.hanh_trang_si_tu_4);
        arrayListImg5.add(R.drawable.hanh_trang_si_tu_5);
        activityBigRegular.add(new ActivityBigRegular("Chương trình tình nguyện: “Hành trang sĩ tử”",
                "\tTháng 3, tháng của mùa thi cử, thời điểm các sĩ tử 12 gấp rút chuẩn bị cho công cuộc ôn thi Đại học, kì thi lớn nhất của đời học sinh. Tuổi học trò nhiều mơ mộng ao ước, tuổi học trò nhiều khát vọng và những niềm tin, cánh cửa Đại học với các em học sinh dường như là bước ngoặt quan trọng và quyết định cho tương lai, con đường học tập và những định hướng sau này. Hiểu được những tâm tư, tình cảm, những băn khoăn trăn trở về dự định, mục tiêu của các em, hằng năm, cứ mỗi khi mùa thi đến, anh chị tình nguyện viên của Đội SVTN Đồng hương Quảng Ninh lại rộn ràng thực hiện chương trình “Hành trang sĩ tử”.\n",
                R.drawable.hanh_trang_si_tu_2,
                "\tVới mục đích tư vấn, cung cấp thông tin, những kiến thức hữu ích cần thiết, là hành trang để các em bắt đầu cho mùa thi cử. Anh chị sinh viên tình nguyện sẽ đem đến cho các em cả những hứng khởi và niềm tin, sẽ cho các em thấy tinh thần trẻ, tràn trề nhiệt huyết, năng động của sinh viên, đặc biệt là sinh viên tình nguyện. Hứa hẹn môi trường sống sinh viên với những trải nghiệm tuyệt vời khi em bước chân vào ngôi trường đại học.\n" +
                "\tMỗi năm, “Hành trang sĩ tử” sẽ về một trường Trung học phổ thông dưới Quảng Ninh để thực công tác tư vấn tuyển sinh. Mang tính chất là một trường trình nhiều ý nghĩa, với nhiệm vụ và bổn phận đem tình yêu, nhiệt huyết, là những người truyền cảm hứng cho các em học sinh, Hành trang sĩ tử năm nào cũng nhận được  sự giúp đỡ và hưởng ứng tích cực từ phía nhà trường, học sinh và năm nào cũng đạt được những thành công rực rỡ.\n",
                arrayListImg5));

        ArrayList<Integer> arrayListImg6 = new ArrayList<>();
        arrayListImg6.add(R.drawable.snd1);
        arrayListImg6.add(R.drawable.snd2);
        arrayListImg6.add(R.drawable.snd3);
        arrayListImg6.add(R.drawable.snd4);
        arrayListImg6.add(R.drawable.snd5);
        arrayListImg6.add(R.drawable.snd6);
        activityBigRegular.add(new ActivityBigRegular("Chương trình nội bộ thường niên – Sinh nhật Đội",
                "\tNgày 08/05/2002, ngày thành lập Đội SVTN Đồng hương Quảng Ninh, một trong những tổ Đội tình nguyện có bề dày lịch sử lâu đời nhất Hội Sinh viên của trường Đại học Kinh tế Quốc dân. Từ đó đến nay, qua ngần ấy năm hoạt động, đơn vị luôn tuân thủ, thực hiện đầy đủ các công tác tình nguyện, nhiệm vụ được giao từ phía Hội Sinh viên cũng như các hoạt động tình nguyện riêng của Đội, là một trong những đơn vị vững mạnh và đạt được không ít thành tích trong những năm tháng hoạt động.\n",
                R.drawable.snd1,
                "\tNgày 08/05 hằng năm là ngày kỉ niệm SINH NHẬT ĐỘI đáng nhớ của Quảng Ninh. Trong ngày này, anh chị em các khóa sẽ cùng về tụ họp đông đủ, gặp nhau để hàn huyên lại những câu chuyện, ôn lại kỉ niệm thời trẻ tình nguyện sôi sục đi cùng tháng năm. Sinh nhật Đội còn là dịp để mọi người hân hoan, xúng xính trong những bộ trang phục lộng lẫy, khoe những nét đẹp trẻ trung rạng rỡ, giao lưu những tiết mục văn nghệ, thể hiện tài năng, sự trưởng thành. Mỗi năm, Hai Hòn thêm một tuổi, mỗi năm, lại là một ngày kỉ niệm đáng nhớ như nhau. Bước sang tuổi mới với hứa hẹn đổi thay, phát triển, kinh nghiệm, vì một tổ Đội vững mạnh và trường tồn cùng thời gian.\n",
                arrayListImg6));

        ArrayList<Integer> arrayListImg7 = new ArrayList<>();
        arrayListImg7.add(R.drawable.tsmt1);
        arrayListImg7.add(R.drawable.tsmt2);
        arrayListImg7.add(R.drawable.tsmt3);
        arrayListImg7.add(R.drawable.tsmt4);
        arrayListImg7.add(R.drawable.tsmt5);
        arrayListImg7.add(R.drawable.tsmt6);
        activityBigRegular.add(new ActivityBigRegular("Chương trình tình nguyện: “Tiếp sức mùa thi”",
                "\tMột mùa thi lại đến, những chiếc áo xanh tình nguyện với logo “Hai Hòn” trên lưng lại bắt đầu cuộc hành trình với những hoạt động vô cùng ý nghĩa nằm trong chương trình “Tiếp sức mùa thi”. Chương trình được phát động nhằm  giúp đỡ các sĩ tử khắp nơi về các thành phố lớn để bước vào kỳ thi quan trọng của cuộc đời mình – kỳ thi Đại học, Cao đẳng.\n",
                R.drawable.tsmt1,
                "\tTrong những năm qua, chương trình “Tiếp sức mùa thi” đã trở thành một hoạt động quen thuộc đối với sinh viên, học sinh và cả xã hội ngày nay. Những bóng áo xanh cùng với chiếc mũ tai bèo đội đầu đứng trước các cụm thi đại học trong cái nắng gay gắt của những ngày hè tháng 6 dường như đã trở nên quen thuộc trong mắt không chỉ những thí sinh mà còn với cả những phụ huynh học sinh – những người đưa con em tham gia một trong những kỳ thi quan trọng nhất của cuộc đời. \n" +
                        "\n" +
                        "\tKỳ thi tuyển sinh ĐH - CĐ tới gần cũng là lúc chiến dịch “Tiếp sức mùa thi” của Đội SVTN Đồng hương Quảng Ninh bắt đầu. Dưới cái nắng mùa hè đổ lửa là màu áo xanh tình nguyện với khuôn mặt đẫm ướt mồ hôi nhưng lúc nào cũng niềm nở nụ cười. Những trái tim nhiệt thành đang hằng ngày, hằng giờ tiếp sức cùng các thí sinh, thắp sáng niềm tin cho các em trên chặng đường đầu tiên vào đời.\n" +
                        " \n" +
                        "\tNhững công việc của các tình nguyện viên Hai Hòn tuy khá nhỏ bé nhưng ý nghĩa thì vô cùng lớn lao. Để hỗ trợ tốt cho thí sinh vào những ngày thi ĐH – CĐ, các bóng áo xanh lại lập các chốt khắp mọi nẻo đường thành phố để chỉ dẫn các thí sinh đến địa điểm thi an toàn nhất, đúng giờ nhất. Ngoài ra, các tình nguyện viên còn hỗ trợ cho người nhà thí sinh dự thi bằng những lời hỏi han, những lời tâm sự trong quá trình chờ đợi, là những hộp cơm, những chai nước tuy không được trọn vẹn nhưng lại đầy ắp tình yêu thương, sự đùm bọc che chở.  Đó cũng là lúc họ trở thành các chiến sỹ trật tự tham gia giải tỏa kẹt đường, kẹt xe, hoặc dẹp trật tự, làm hàng rào an toàn giúp phân luồng giao thông tại các cổng trường nơi có các hội đồng thi.\n" +
                        "\n" +
                        "\tVà kết thúc một ngày dài tuy mệt mỏi nhưng đầy niềm vui và ý nghĩa, những tình nguyện viên của Hai Hòn lại tề tựu đông đủ cùng với những người anh em của các tổ Đội tình nguyện khác tại ký túc xá trường đại học Kinh Tế Quốc Dân. Từ nơi ấy, những tiếng đàn lại vang lên, những câu hát tình nguyện được cất lên trong vòng tròn họp Đội hơn một nghìn người – một con số tưởng như không thể nào tin được. Và cũng chính từ nơi này, những kỷ niệm ,những khoảnh khắc đáng nhớ nhất trong suốt quãng đời sinh viên được tạo nên, những khoảnh khắc ấy – cũng chính là tuổi trẻ, là thanh xuân đong đầy hoài bão, sức trẻ, nhiệt huyết cùng những cảm giác mới mẻ lần đầu trải nghiệm. Tuổi trẻ ấy - có bạn bè, có đồng đội, cùng kề vai sát cánh bên nhau không chỉ trong những ngày hè nóng nực oi ả của tháng 6 mà là còn suốt quãng đời sinh viên, nơi mái nhà Hai Hòn. \n" +
                        " \n" +
                        "\tMùa thi đi qua, những tình nguyện viên của Hai Hòn tiễn các em thí sinh trở về các tỉnh với những cái bắt tay nhau cảm động, cùng hứa hẹn sẽ gặp lại nhau nơi giảng đường Đại học. Cùng với đó, những màu áo xanh ấy lại tiếp tục hướng đến những trải nghiệm mới mẻ khác, thú vị hơn, lớn lao hơn được anh chị khóa trên “quảng cáo” rất nhiều từ trước đó rất, rất lâu – chiến dịch “Mùa hè thanh niên tình nguyện”  được tổ chức ngay sau chương trình “Tiếp sức mùa thi”. Hai tuần được cùng nhau sinh hoạt, cùng nhau làm việc dưới những xã vùng sâu, vùng xa, những nơi còn khó khăn trên địa bàn tình Quảng Ninh sẽ là vô cùng lý thú, mới lạ và hấp dẫn. Nhưng chắc chắn rằng, những kỷ niệm trong hai ngày một đêm tham gia “Tiếp sức mùa thi” sẽ là một phần hành trang không thể thiếu của những thành viên Hai Hòn trên chặng đường đi về với vùng đất mỏ quen thuộc – quê hương Quảng Ninh yêu dấu. Và những ký ức sâu đậm về vòng tròn họp Đội, những tiết mục văn nghệ “công phu” trong những phòng sinh hoạt của KTX hay những phi vụ “giết anh chị” bằng dầu ăn, nước rửa bát,…từ “Tiếp sức mùa thi” sẽ mãi mãi là một phần quan trọng trong con tim mỗi người, là một phần của tuổi thanh xuân, của một thời sinh viên đầy hòa bão, ước mơ, trải nghiệm bên bạn bè, đồng đội, bên mái nhà Hai Hòn, của một thời tuổi trẻ đồng hành cùng Đội SVTN Đồng hương Quảng Ninh – “Đội sinh viên tình nguyện hàng đầu Quảng Ninh”\n",
                arrayListImg7));

        ArrayList<Integer> arrayListImg8 = new ArrayList<>();
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_1);
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_2);
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_3);
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_4);
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_5);
        arrayListImg8.add(R.drawable.mua_he_thanh_nien_tinh_nguyen_6);
        activityBigRegular.add(new ActivityBigRegular("Chiến dịch “Mùa hè thanh niên tình nguyện”",
                "\t“Bao yêu thương ơi mùa hè xanh vấn vương, đi muôn phương lưu luyến tình quê hương. Trong tim ta ơi mùa hè xanh thiết tha. Vang câu ca trên những chặng đường xa……”\n",
                R.drawable.mua_he_thanh_nien_tinh_nguyen_3,
                "\tCuộc đời một người thanh niên tình nguyện không thể không biết đến cụm từ MÙA HÈ XANH, chiến dịch lớn được mong chờ nhất năm mà bất kì tình nguyện viên nào cũng khao khát trải nghiệm. Sẽ không có gì lạ khi nói: Thật quá đáng tiếc cho một người tình nguyện viên nào nếu không được nếm trải mùi vị của chiến dịch hè….\n" +
                        "Hè xanh….nắng đổ\n" +
                        "Hè xanh…xạm da\n" +
                        "Hè xanh…mồ hôi\n" +
                        "Hè xanh…niềm vui\n" +
                        "Hè xanh…nước mắt\n" +
                        "Hè xanh…máu \n" +
                        "\n" +
                        "\tNhững bữa cơm hè đạm bạc, thiếu thốn, những ngày đi làm vất vả, nắng nôi, những tối sinh hoạt giản dị, những trò đùa nghịch cùng nhau và mải miết kể nhau nghe những câu chuyện một ngày. Hôm nay anh đi làm, tôi hậu cần, ngày mai đổi lại, để mỗi sáng cùng nhau cất lên tiếng chào “Hậu cần chào Đi làm, chúc một buổi năng suất!”, để mỗi trưa hay chiều làm về như một đoàn quân dạo bước, hát vang khúc ca tình nguyện, đánh bay mỏi mệt một ngày. Khói bếp hậu cần cay xè mắt, “Cảm ơn hậu cần cho ta những bữa ăn ngon”. Những đêm đêm các cậu An ninh thao thức, trông giấc ngủ cho mọi người, đập muỗi le ve và kể nghìn lể một đêm những câu chuyện hài không chán. Chưa bao giờ, những người không cùng huyết thống, không thân thích hay họ hàng lại yêu thương, đùm bọc và giúp đỡ nhau và gắn kết với nhau đến thế. Chiến dịch hè chính là đồng cam cộng khổ, chiến dịch hè là xương máu có nhau, chiến dịch hè là niềm vui cùng cười, nỗi buồn cùng khóc. Hè xanh, là khi người ta thấy rõ nhất ý nghĩa của hai từ ĐỒNG ĐỘI, là khi người ta hiểu thế nào là “Đêm rét chung chăn thành đôi tri kỉ”, thế nào là “Ngày nóng chia nhau từng ngụm nước, nắm cơm”. \n" +
                        "\tChiến dịch kéo dài 14 ngày, khoảng thời gian đủ để cho các tình nguyện viên trải nghiệm một cuộc sống hoàn toàn khác biệt. Rời khỏi chốn thành đô sa hoa, lộng lẫy, rời khỏi vòng tay bao bọc của gia đình, anh chị em, gác lại những công việc vui chơi ngày, học thêm, làm thêm… thay vào đó là có một chuyến đi tình nguyện thực tế hữu ích. Không một ai có thể diễn tả được trôi chảy, mạch lạc sau hè xanh người ta đã học được những gì. Vì tất cả những niềm vui, nỗi xúc động, tất cả những kinh nghiệm, trải nghiệm, những tình cảm sâu sắc đến mức không một ngôn từ nào có thể biểu lộ rõ ràng.\n" +
                        "\tCó người khi được hỏi về hè xanh, họ cười rồi bật khóc ngay sau đó. Có lẽ là những giá trị mà một chiến-dịch-hè để lại quá nhiều những dư âm và chất chứa những hạnh phúc chẳng thể nào quên được. Hãy tưởng tượng khi bạn xa nhà vào những ngày hè, không phải đi du lịch mà là đi làm việc, những công việc mà từ nhỏ tới lớn chưa bao giờ thử qua: gặt lúa, đào mương, làm đường, trồng cây, xây rào.... Bạn cùng với những người Đồng Đội của mình làm tất cả những công việc có ý nghĩa ấy, thử qua cảm giác một cuộc sống lành mạnh, khỏe khoắn, điều độ và không có công nghệ hay di động… Một cảm giác tuyệt vời với cuộc sống đơn giản, không bon chen, không lo toan chỉ toàn là những niềm vui giản dị….\n" +
                        "\tChiến dịch hè, có nhiều đoạn văn, câu chữ nữa cũng không thể diễn tả hết được, phải cảm nhận bằng trải nghiệm thực và trái tim….\n" +
                        "\n" +
                        "\t“Chiến dịch hè thanh niên tình nguyện”, không thẻ bỏ lỡ! Khi nhớ về tuổi trẻ, thanh xuân của một con người từng làm tình nguyện, một mảng kí ức lớn, không thể không có MÙA-HÈ-XANH!\n" +
                        "\tMỗi khi hè đến, hòa chung với không khí tình nguyện của cả nước, Đội SVTN đồng hương Quảng Ninh lại lên đường tham gia Chiến dịch Mùa hè thanh niên tình nguyện. Đội đã tham gia 14 mùa hè tình nguyện tại những địa điẻm khác nhau trên địa bàn tỉnh Quảng Ninh: Thanh Sơn - huyện Ba Chẽ (2002), Hoành Bồ (2003), Bình Dân - Vân Đồn (2004), Hải Hoà - Móng Cái (2005), Đài Xuyên - Vân Đồn (2006), Ba Chẽ (2007), Hải Sơn - Móng Cái (2008), Hòa Bình - Hoành Bồ (2009), Dực Yên - Đầm Hà (2010), Yên Than - Tiên Yên (2011), Húc Động - Bình Liêu (2102), Quảng Thắng - Hải Hà (2013), Quảng Nghĩa - Móng Cái (2014), Vô Ngại - Bình Liêu (2015), Hải Sơn - Móng Cái (2016).\n",
                arrayListImg8));

        ArrayList<Integer> arrayListImg9 = new ArrayList<>();
        arrayListImg9.add(R.drawable.ttce1);
        arrayListImg9.add(R.drawable.ttce2);
        arrayListImg9.add(R.drawable.ttce3);
        arrayListImg9.add(R.drawable.ttce4);
        arrayListImg9.add(R.drawable.ttce5);
        arrayListImg9.add(R.drawable.ttce6);
        activityBigRegular.add(new ActivityBigRegular("Chương trình tình nguyện kết hợp giao lưu văn nghệ: “Trung thu cho em”",
                "\t“Tết trung thu em rước đền đi chơi, em rước đèn đi khắp phố phường..”",
                R.drawable.ttce4,
                "\tTrung thu cho em là chương trình thường niên có ý nghĩa lớn của Đội SVTN Đồng hương Quảng Ninh. Hằng năm, cứ vào dịp trăng rằm, các cô cậu sinh viên tình nguyện của Quảng Ninh lại tất bật chuẩn bị, trang trí, gói quà, làm đèn lồng, ông sao, chuẩn bị mâm ngũ quả, bánh kẹo và không thể thiếu là những tiết mục văn nghệ rộn ràng đặc sắc cho các em nhỏ vui tết trung thu, rước đèn, phá cỗ.\n",
                arrayListImg9));

        ArrayList<Integer> arrayListImg10 = new ArrayList<>();
        arrayListImg10.add(R.drawable.lang_tre_hoa_binh_1);
        arrayListImg10.add(R.drawable.lang_tre_hoa_binh_2);
        activityBigRegular.add(new ActivityBigRegular("Đi làng trẻ Hòa Bình – Thanh Xuân",
                "Làng trẻ Hòa Bình – Thanh Xuân, Hà Nội là một trong những điểm đến hoạt động tình nguyện hàng tuần phải kể đến đầu tiên của Đội SVTN Đồng hương Quảng Ninh.\n" +
                        "“Trẻ em như búp trên cành\n" +
                        "Biết ăn, biết ngủ, biết học hành là ngoan”\n",
                R.drawable.lang_tre_hoa_binh_1,
                "\tKhông phải em bé nào sinh ra cũng may mắn được thượng đế ban tặng đủ đầy, có những đứa trẻ tật nguyền, có những đứa khiếm khuyết, có những em lại từ bé đã mang trong mình những căn bệnh bẩm sinh. Tất cả trẻ em đều xứng đáng có được những niềm vui, tiếng cười, hòa nhập như các bạn cùng trang lứa. Làng trẻ Hòa Bình, trung tâm hỗ trợ phục hồi chức năng, cũng là nơi dạy dỗ, môi trường để những em bé thiệt thòi ấy học tập, vui chơi phát triển. Chúng tôi, những tình nguyện viên của Đội SVTN Đồng hương Quảng Ninh vẫn luôn hi vọng mang đến cho các em tình yêu thương và những nụ cười. Cứ hai buổi chiều một tuần, chúng tôi lại gác lại những bộn bề học tập, công việc để đến với Làng trẻ Hòa Bình. Vài ba tiếng buổi chiều ngắn ngủi được đến vui chơi, múa hát, dạy các em nhỏ viết chữ, tô màu, tập tô, cùng các em chơi những trò chơi là niềm vui giản dị mà thật ý nghĩa đối với cô cậu sinh viên chúng tôi. \n" +
                        "\tCác em nhỏ ở Hòa Bình đều là những đứa trẻ đáng yêu! “Chị ơi, sao hôm nay chị ấy không đến? Chị ấy bận học ạ?!” Có những niềm vui nhỏ nhoi xúc động chẳng thể nói thành lời khi các em nhớ tên chúng tôi, khi chúng nó cố ghi nhớ cả phù hiệu gắn trên áo xanh, ghi nhớ ngôi trường đại học chúng tôi học, rồi nhớ nhung mỗi lần một gương mặt anh chị thân quen không đến. Những nét ngây ngô hồn nhiên, những nụ cười rạng rỡ, cử chỉ vô tư âu yếm làm chúng tôi như đánh bay đi những mỏi mệt khi đến thăm và chơi cùng các em ở làng trẻ, chỉ còn lại là những niềm vui, tiếng cười. Những lúc ấy, chúng tôi quả thực cảm thấy “Làm tình nguyện viên được nhiều lắm. Được nhiều hơn cả những đợi mong”\n",
                arrayListImg10));

        ArrayList<Integer> arrayListImg11 = new ArrayList<>();
        arrayListImg11.add(R.drawable.vien_duong_lao_1);
        arrayListImg11.add(R.drawable.vdl1);
        arrayListImg11.add(R.drawable.vdl2);
        arrayListImg11.add(R.drawable.vdl3);
        arrayListImg11.add(R.drawable.vdl4);
        arrayListImg11.add(R.drawable.vdl5);
        activityBigRegular.add(new ActivityBigRegular("Đi viện dưỡng lão Bách niên Thiên Đức",
                "\tĐi viện dưỡng lão Thiên Đức – Đông Ngạc – Từ Liêm – Hà Nội, hoạt động tình nguyện mỗi tháng chỉ diễn ra một lần của Đội SVTN Đồng hương Quảng Ninh. Đến với trung tâm chăm sóc người cao tuổi Thiên Đức, các bạn tình nguyện viên sẽ giúp đỡ những anh chị phụ trách chăm sóc các cụ, ngồi trò chuyện, đấm bóp vai, cho các cụ ăn….\n",
                R.drawable.vdl5,
                "\tVà đặc biệt, các bạn sinh viên tình nguyện sẽ đem đến cho các cụ viện dưỡng lão Thiên Đức một-chương-trình-văn-nghệ vô cùng đặc sắc, những điệu múa truyền thống uyển chuyển, những khúc dân ca và cả những bài hát trẻ tươi vui rộn ràng, những bước nhảy, những trò chơi và phần quà ý nghĩa.Với hi vọng chương trình sẽ để lại những ấn tượng tốt đẹp, xây dựng được bầu không khí tràn ngập niềm vui, hân hoan, hào hứng mỗi lần Đội làm công tác tình nguyện ở viện dưỡng lão Thiên Đức.\n",
                arrayListImg11));

        ArrayList<Integer> arrayListImg12 = new ArrayList<>();
        arrayListImg12.add(R.drawable.chua_1);
        arrayListImg12.add(R.drawable.chua_2);
        arrayListImg12.add(R.drawable.chua_3);
        activityBigRegular.add(new ActivityBigRegular("Đi hỗ trợ chùa Pháp Vân",
                "\tTrong hai tuần đầu tiên của tháng, vào mỗi sáng chủ nhật, hoạt động tình nguyện không thể thiếu của Đội SVTN Đồng hương Quảng Ninh là hỗ trợ công việc ở chùa Pháp Vân – Giáp Bát, Giải Phóng, Hà Nội.\n",
                R.drawable.chua_1,
                "\tBạn sẽ làm gì vào ngày cuối tuần của mình? Nhâm nhi một tách café, hóng không khí thong thả buổi sáng ngày nghỉ, thư thái đọc một cuốn sách yêu thích hay ra ngoài tụ tập, vui chơi cùng bạn bè? Với riêng những tình nguyện viên của Quảng Ninh thì một sáng cuối tuần ý nghĩa là những phút giây được cùng nhau làm việc, trò chuyện, giúp đỡ nhà chùa dọn dẹp khuôn viên. Có những ngày đại lễ, lại tất bật giúp các thầy, các sư sắp lễ chuẩn bị, rồi cùng vào ngồi nghe kinh, học phật, học hát. Những bữa cơm trưa mà các cô, các thầy tự tay nấu cho các tình nguyện viên, mộc mạc, đạm bạc mà vẫn chan chứa niềm vui. Đi chùa Pháp Vân không chỉ là hoạt động có ý nghĩa mà tựu chung còn là hoạt động thường kì để lại nhiều kỉ niệm nhất đối với các khóa hoạt động của Hai Hòn.\n",
                arrayListImg12));

        ArrayList<Integer> arrayListImg13 = new ArrayList<>();
        arrayListImg13.add(R.drawable.phat_chao_1);
        arrayListImg13.add(R.drawable.phat_chao_2);
        arrayListImg13.add(R.drawable.phat_chao_3);
        arrayListImg13.add(R.drawable.phat_chao_4);
        arrayListImg13.add(R.drawable.phat_chao_5);
        arrayListImg13.add(R.drawable.phat_chao_6);
        activityBigRegular.add(new ActivityBigRegular("Đi phát cháo cùng chùa Pháp Vân tại Bệnh viện K",
                "\tTrong những ngày nắng nóng oi ả báo hiệu một mùa hè lại sắp sửa đến gần, Đội SVTN Đồng hương Quảng Ninh chúng tôi lại tiếp tục cuộc hành trình tình nguyện của mình - phát đồ ăn hỗ trợ chùa Pháp Vân ( đường Giải Phóng, quận Hoàng Mai, Hà Nội) tại Bệnh viện K.\n",
                R.drawable.phat_chao_1,
                "\tĐược trao tận tay những suất ăn tuy không quá cao sang nhưng lại đong đầy tình thương và sự chân thành từ những con người với tấm lòng nhân hậu, với hành động đáng trân trọng đến với những bệnh nhân là một trải nghiệm vô cùng mới mẻ và cũng rất lý thú của những thành viên và cộng tác viên của Hai Hòn. Những tình nguyện viên đã có những thời gian thật vui vẻ bên nhau, cùng nhau làm việc, cùng nhau giúp đỡ những người có hoàn cảnh khó khăn, những mảnh đời còn gặp nhiều bất hạnh trong cuộc sống, giúp họ cảm thấy ấm áp, cảm thấy cuộc sống này thật nhiều điều đáng quý và đáng trân trọng. Niềm vui, sư phấn khởi hiện lên trên gương mặt của mọi người là động lực để chúng tôi – những tình nguyện viên của Hai Hòn, cứ mỗi tuần lại có mặt trên chuyến xe xuất phát từ chùa Pháp Vân đến bệnh viện để tiếp tục công việc phân phát đồ ăn, nước uống đến cho mọi người. Những lời cảm ơn, những cái nhìn đầy trìu mến, thương yêu không chỉ của những bênh nhân nơi đây mà còn của cả những y, bác sĩ, những cô bác nội trợ cung cấp những suất ăn miễn phí này dành cho chúng tôi cũng là một nguồn động lực không nhỏ để những màu áo xanh không quản ngại nắng mưa, gió bụi, hàng tuần vượt quãng đường xa xôi đến với chùa, phụ giúp các cô bác nấu ăn, quét dọn, rồi lại cùng đồng hành trên chuyến xe đầy ắp tình thương và lòng nhân ái ấy. Chắc chắn rằng, hoạt động này sẽ còn được duy trì lâu dài và cùng với những màu áo xanh mang logo “Hai Hòn”, hình ảnh các tình nguyện viên của Đội SVTN Đồng hương Quảng Ninh trao tận tay những bát cháo, những cốc chè,… cho người bệnh, những người có hoàn cảnh khó khăn sẽ trở thành một nét đẹp, một điều đáng trân quý trong cuộc sống thủ đô tấp nập - nơi bộn bề lo toan và bận rộn này.\n",
                arrayListImg13));
    }

    private void initItems() {
        int position = getIntent().getIntExtra("ACTHERE", 0);
        mCurrentActListing = activityBigRegular.get(position);
        tvTitle.setText(mCurrentActListing.getTitleAct());
        tvContentFirst.setText(mCurrentActListing.getContentFirstAct());
        tvContentSecond.setText(mCurrentActListing.getSecondFirstAct());
        ivContent.setImageResource(mCurrentActListing.getImgAct());

        ImgActAdapter imgActAdapter = new ImgActAdapter(getApplicationContext(), mCurrentActListing.getArrayFeaturedImages());
        vpgAct.setAdapter(imgActAdapter);
        indicator.setViewPager(vpgAct);
        vpgAct.startAutoScroll();
        vpgAct.setInterval(4000);

    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_big_regular);
        tvTitle = (TextView) findViewById(R.id.text_view_title_act);
        tvContentFirst = (TextView) findViewById(R.id.content_activity_1);
        ivContent = (ImageView) findViewById(R.id.content_activity_image);
        tvContentSecond = (TextView) findViewById(R.id.content_activity_2);

        vpgAct = (cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager) findViewById(R.id.vpg_img_act);
        indicator = (CircleIndicator) findViewById(R.id.indicator_act);
        toolbar.setTitle("Chi tiết hoạt động");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        vpgAct.stopAutoScroll();
        vpgAct.destroyDrawingCache();
    }

    @Override
    protected void onStop() {
        super.onStop();
        vpgAct.stopAutoScroll();
        vpgAct.destroyDrawingCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vpgAct.stopAutoScroll();
        vpgAct.destroyDrawingCache();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        vpgAct.stopAutoScroll();
        vpgAct.destroyDrawingCache();
    }
}
