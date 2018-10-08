package ir.debook.debook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import MessageCore.Message;
import MessageCore.MessageType;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder> {
    List<Message> messages;
    Context context;
    LayoutInflater inflater;
    public MessageListAdapter(List<Message> messages,Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public MessageListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_message,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MessageListAdapter.ViewHolder holder, int position) {
        final Message messageCu = messages.get(position);
        holder.title.setText(messageCu.getTitle());
        holder.text.setText(messageCu.getText());
        if (messageCu.getMessageType() != MessageType.NONE){
            holder.button.setText(messageCu.getButtonText());
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    messageCu.readMessage();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,text;
        public Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            text = (TextView) itemView.findViewById(R.id.text);
            button = (Button) itemView.findViewById(R.id.button);

        }
    }
}
