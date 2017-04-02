package stephencavallaro.demostephencavallaro.dialog;

        import android.app.Dialog;
        import android.content.Context;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.widget.RadioGroup;


        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;
        import stephencavallaro.demostephencavallaro.R;




public class FinalQuiz extends Dialog {


    private int checkedID;

    @BindView(R.id.rdg)
    RadioGroup radiogroup;

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        if(checkedID==R.id.rb1){listener.onClickListener();

        }
        else if(checkedID==R.id.rb2){listener.onClick2Listener();
        }
        dismiss();
    }
    public FinalQuiz(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }@OnClick(R.id.dialog_cancel)
    public void cancelClick(){
        listener.onClickCancel();
        dismiss();}


    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClick2Listener();
        public void onClickCancel();

    } @Override



    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.finalquiz);
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;



            }
        });


    }
}
