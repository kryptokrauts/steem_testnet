import json
from pprint import pprint

data = json.load(open('accounts.json'))

ownerKey = data['result'][0]['owner']['key_auths'][0][0]
activeKey = data['result'][0]['active']['key_auths'][0][0]
postingKey = data['result'][0]['posting']['key_auths'][0][0]
memoKey = data['result'][0]['memo_key']

#print(ownerKey);
#print(activeKey);
#print(postingKey);
#print(memoKey);

data = json.load(open('keys.json'))

for key in data:		
	if ownerKey == key[0]:
		print('ownerKey;{};{}'.format(ownerKey,key[1]))
	elif activeKey == key[0]:
		print('activeKey;{};{}'.format(activeKey,key[1]))
	elif postingKey == key[0]:
		print('postingKey;{};{}'.format(postingKey,key[1]))
	elif memoKey == key[0]:
		print('memoKey;{};{}'.format(memoKey,key[1]))
	else:
		print('otherKey;{};{}'.format(key[0],key[1]))
