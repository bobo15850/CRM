package com.nju.edu.crm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nju.edu.crm.R;
import com.nju.edu.crm.common.enums.CustomerType;
import com.nju.edu.crm.model.entity.Customer;

import java.util.List;

/**
 * Created by 张波波 on 2016-06-21.
 */
public class CustomerAdapter extends ArrayAdapter<Customer> {
    private int resourceId;

    public CustomerAdapter(Context context, int resource, List<Customer> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Customer customer = getItem(position);
        View view;//得到缓存的布局
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.customerType = (TextView) view.findViewById(R.id.customer_type_text);
            viewHolder.customerName = (TextView) view.findViewById(R.id.customer_name_text);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.customerType.setText(CustomerType.getCustomerType(customer.getCustomertype()).getStrValue());
        viewHolder.customerName.setText(customer.getCustomername());
        return view;
    }

    //用于缓存控件
    class ViewHolder {
        TextView customerType;
        TextView customerName;
    }
}
