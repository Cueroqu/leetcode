import urllib2
import urllib
import cookielib
import re
import HTMLParser
import os

host = 'https://oj.leetcode.com'

def login_leetcode():
    cookie = cookielib.CookieJar()
    handler = urllib2.HTTPCookieProcessor(cookie)
    urlOpener = urllib2.build_opener(handler)
    urlOpener.open(host)

    # get special token of leetcode
    csrftoken = ""
    for ck in cookie:
        csrftoken = ck.value
    login="cuero"
    pwd="8cGKerHu"
    values = {'csrfmiddlewaretoken':csrftoken,'login':login,'password':pwd,'remember':'on'}
    values = urllib.urlencode(values)
    headers = {'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.94 Safari/537.36',
               'Origin':'https://oj.leetcode.com',
               'Referer':'https://oj.leetcode.com/accounts/login/',
               }
    request = urllib2.Request("https://oj.leetcode.com/accounts/login/",values,headers=headers)
    url = urlOpener.open(request)
    page = url.read()
    return headers, urlOpener, page

def get_problem_list():
    h = HTMLParser.HTMLParser()
    sock = urllib.urlopen("https://oj.leetcode.com/problems/")
    html_src = sock.read()
    sock.close()
    ret = re.findall("<td><a href=.+?>(.+)?</a></td>", html_src)
    for index, s in enumerate(ret):
        ret[index] = h.unescape(s).encode('utf-8')
    ret.sort()
    return ret

def get_distance(s1, s2):
    distance = [[0 for i in range(len(s2)+1)] for j in range(len(s1)+1)]
    for i in range(len(s1)+1):
        distance[i][0] = i
    for i in range(len(s2)+1):
        distance[0][i] = i
    for i in range(len(s1)):
        for j in range(len(s2)):
            distance[i+1][j+1] = min(min(distance[i][j+1], distance[i+1][j])+1, distance[i][j] + (0 if s1[i] == s2[j] else 1))
    return distance[i+1][j+1]

def min_distance_problem(origin, problems, to_be_deleted):
    mindis = 4
    ret = None
    for s in problems:
        if s in to_be_deleted:
            continue
        dis = get_distance(origin, s.replace(" ", ""))
        if dis < 4 and mindis > dis:
            mindis = dis
            ret = s
    return ret

def retrieve_information(problems, dirs):
    dir_problem_match = dict()
    unsolved_problem = list()
    unmatched_dirs = list()
    to_be_deleted = set()
    i = j = 0
    pattern = "Problem: {prob}, done in: {dir}"
    while i < len(problems) and j < len(dirs):
        if problems[i].replace(" ", "") == dirs[j]:
            print pattern.format(prob=problems[i], dir=dirs[j])
            dir_problem_match[problems[i]] = dirs[j]
            to_be_deleted.add(problems[i])
            to_be_deleted.add(dirs[j])
            i += 1
            j += 1
            continue
        elif problems[i] < dirs[j]:
            i += 1
        else:
            j += 1
    for s in dirs:
        if (s in to_be_deleted):
            continue
        problem = min_distance_problem(s, problems, to_be_deleted)
        if problem is not None:
            dir_problem_match[problem] = s
            to_be_deleted.add(s)
            to_be_deleted.add(problem)
            print pattern.format(prob=problem, dir=s)
    for s in problems:
        if not s in to_be_deleted:
            print "unsolved: {0}".format(s)
            unsolved_problem.append(s)
    for s in dirs:
        if not s in to_be_deleted:
            unmatched_dirs.append(s)
    return dir_problem_match, unsolved_problem, unmatched_dirs

def generate_code(urlOpener, unsaved_problem):
    pattern = "https://oj.leetcode.com/problems/{name}/submissions"
    for prob in unsaved_problem:
        url_link = pattern.format(name=prob.lower().replace(" ", "-").replace("'", ""))
        print url_link
        sock = urlOpener.open(url_link)
        html_src = sock.read()
        sock.close()
        ret = re.findall("<a.+?href=\"(.+)?\"><strong>Accepted</strong></a>", html_src)
        path = prob.replace(" ", "") + "/src/"
        if len(ret) > 0:
            os.makedirs(path)
            print path
        for index, s in enumerate(ret):
            url_link = "https://oj.leetcode.com{suffix}".format(suffix=s)
            print url_link
            sock = urlOpener.open(url_link)
            html_src = sock.read()
            sock.close()
            ret = re.search("storage.put\('java', '(.+)?'\)", html_src)
            code = ret.group(1).decode("unicode_escape", "ignore")
            with open(path + "Solution" + ("" if index==0 else str(index+1)) + ".java", "a") as new_file:
                new_file.write(code)
                new_file.close()

def search_page(page):
    index = 0
    print page
    while True:
        index = page.find('class="ac"',index)
        if index != -1:
             index += 1
             start = page.find('<td><a href="',index)
             finis = page.find('">',start)
             tmpfin = page.find('<',finis)
             title = page[finis + 2:tmpfin]
             print myhost + page[start + 13:finis]
        else:
             break

if __name__ == '__main__':
    headers, urlOpener, page = login_leetcode()
    # search_page(page)
    problems = get_problem_list()
    dirs = filter(lambda x : not x.startswith("."), os.listdir("."))
    dirs.sort()
    dir_problem_match, unsaved_problem, unmatched_dirs = retrieve_information(problems, dirs)
    generate_code(urlOpener, unsaved_problem)
    #print dir_problem_match
    #print unsaved_problem
    #print unmatched_dirs